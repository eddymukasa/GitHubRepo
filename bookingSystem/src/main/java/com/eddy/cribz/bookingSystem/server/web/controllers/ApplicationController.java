package com.eddy.cribz.bookingSystem.server.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eddy.cribz.bookingSystem.core.security.util.ProcnetSecurityUtil;
import com.eddy.cribz.bookingSystem.core.service.UserService;
import com.eddy.cribz.bookingSystem.model.User;
import com.eddy.cribz.bookingSystem.model.exceptions.SessionExpiredException;
import com.eddy.cribz.bookingSystem.model.exceptions.ValidationFailedException;
import com.eddy.cribz.bookingSystem.server.web.controllers.formbacking.GenericCommand;




@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;

	private Logger log = LoggerFactory.getLogger(ApplicationController.class);

	/**
	 * handles the index page request.
	 * 
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping(value = { "/" }) public ModelAndView
	 * welcomeHandler(ModelMap model) { return new ModelAndView("welcome",
	 * model); }
	 */

	/**
	 * handles the service login
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/ServiceLogin" })
	public ModelAndView loginHandler(ModelMap model) {
		return new ModelAndView("loginView", model);
	}

	@RequestMapping(value = "/Recovery", method = RequestMethod.GET)
	public String recoveryHandler() {
		return "recoveryView";
	}

	@RequestMapping(value = "/Recovery", method = RequestMethod.POST)
	public ModelAndView recoveryHandler(
			@RequestParam("username") String username, ModelMap model) throws SessionExpiredException {
		User user = userService.getUserByUsername(username);
		if (user != null) {
			String password = ProcnetSecurityUtil
					.generatePassword(8);
			try {
				userService.changePassword(password, user, true, false);
			} catch (ValidationFailedException e) {
				log.error(ApplicationController.class.getName(), e);
			}

			return new ModelAndView("recoverysuccess", model);
		} else {
			model.put(WebConstants.ERROR_MESSAGE_MODEL_PARAM,
					"user with username: \"" + username + " \"  does not exist");

			return new ModelAndView("recoveryerror", model);
		}
	}

	/**
	 * handles service login failure.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/ServiceLoginFailure" })
	public ModelAndView loginFailureHandler(ModelMap model) {
		model.put(WebConstants.ERROR_MESSAGE_MODEL_PARAM,
				"username or password is incorrect.");
		return new ModelAndView("loginView", model);
	}

	@RequestMapping(value = "/AccessDenied")
	public ModelAndView accessDeniedHandler(ModelMap model) {
		model.put(WebConstants.ERROR_MESSAGE_MODEL_PARAM,
				"you don't have sufficient priviledges to access this resource.");
		return new ModelAndView("loginView", model);
	}

	@RequestMapping(value = "/errors/404")
	public ModelAndView error404Handler() {
		return new ModelAndView("404");
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(ModelMap model) {
		model.put("form", new GenericCommand());
		return new ModelAndView("changepassword", model);
	}

	/**
	 * handles the request to change the password
	 * 
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(
			@ModelAttribute("form") GenericCommand command, ModelMap model) {
		try {
			User loggedInUser = ProcnetSecurityUtil.getLoggedInUser();

			String oldPassword = command.getStringValue("oldpassword");
			String hashedPassword = ProcnetSecurityUtil
					.encodeString2(oldPassword + loggedInUser.getSalt());

			String hashedPassword2 = ProcnetSecurityUtil
					.encodeString(oldPassword + loggedInUser.getSalt());

			if (StringUtils.equals(hashedPassword, loggedInUser.getPassword())
					|| StringUtils.equals(hashedPassword2,
							loggedInUser.getPassword())) {
				String newPassword = command.getStringValue("newpassword");
				String newPassword2 = command.getStringValue("newpassword2");

				if (StringUtils.equals(newPassword, newPassword2)) {
					User currentUser = userService.getUserById(loggedInUser
							.getId());
					if (currentUser != null) {
						currentUser.setClearTextPassword(newPassword2);
						userService.saveUser(currentUser);
						model.put(WebConstants.SYSTEM_MESSAGE_MODEL_PARAM,
								"password changed successfully.");
					}
				} else {
					model.put(WebConstants.ERROR_MESSAGE_MODEL_PARAM,
							"the new password don't match.");
				}
			} else {
				model.put(WebConstants.ERROR_MESSAGE_MODEL_PARAM,
						"old password does not match the current password.");
			}
		} catch (Exception ex) {
			model.put(WebConstants.ERROR_MESSAGE_MODEL_PARAM, ex.getMessage());
		}

		model.put("form", new GenericCommand());
		return new ModelAndView("changepassword", model);
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
}
