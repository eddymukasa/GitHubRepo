package com.eddy.cribz.bookingSystem.core.service.Impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eddy.cribz.bookingSystem.core.ProcnetConstants;
import com.eddy.cribz.bookingSystem.core.dao.PasswordPolicyDAO;
import com.eddy.cribz.bookingSystem.core.dao.PermissionDAO;
import com.eddy.cribz.bookingSystem.core.dao.RoleDAO;
import com.eddy.cribz.bookingSystem.core.dao.UserDAO;
import com.eddy.cribz.bookingSystem.core.email.EmailService;
import com.eddy.cribz.bookingSystem.core.security.util.ProcnetSecurityUtil;
import com.eddy.cribz.bookingSystem.core.service.UserService;
import com.eddy.cribz.bookingSystem.core.templating.TemplatingEngine;
import com.eddy.cribz.bookingSystem.core.templating.TemplatingUtils;
import com.eddy.cribz.bookingSystem.core.utils.ApplicationContextProvider;
import com.eddy.cribz.bookingSystem.model.PasswordPolicy;
import com.eddy.cribz.bookingSystem.model.Permission;
import com.eddy.cribz.bookingSystem.model.PolicyStatus;
import com.eddy.cribz.bookingSystem.model.RecordStatus;
import com.eddy.cribz.bookingSystem.model.RegularExpression;
import com.eddy.cribz.bookingSystem.model.Role;
import com.eddy.cribz.bookingSystem.model.RoleStatus;
import com.eddy.cribz.bookingSystem.model.User;
import com.eddy.cribz.bookingSystem.model.exceptions.OperationFailedException;
import com.eddy.cribz.bookingSystem.model.exceptions.SessionExpiredException;
import com.eddy.cribz.bookingSystem.model.exceptions.ValidationFailedException;
import com.eddy.cribz.bookingSystem.model.security.PermissionConstants;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * Prepares the search to be used in searching users
	 * 
	 * @param query
	 * @return
	 */
	public static Search prepareUserSearchByLoginName(String query) {
		Search search = new Search();
		String param = new StringBuilder().append("%")
				.append(StringEscapeUtils.escapeSql(query)).append("%")
				.toString();
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);
		search.addFilterLike("username", param);
		search.addSort("username", false, true);

		return search;
	}

	@Autowired
	private EmailService emailService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PermissionDAO permissionDao;

	@Autowired
	private RoleDAO roleDao;

	@Autowired
	private PasswordPolicyDAO passwordPolicyDao;

	@Autowired
	private TemplatingEngine templatingEngine;

	@Autowired
	private UserDAO userDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void activateUserAccount(User user) {
		User activatedUser = getUserById(user.getId());
		activatedUser.setStatus(Boolean.TRUE);
		userDao.save(activatedUser);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void changePassword(String password, User user)
			throws ValidationFailedException {
		changePassword(password, user, true, true);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User changePassword(String password, User user,
			boolean sendChangePasswordNotification)
			throws ValidationFailedException {
		return changePassword(password, user, sendChangePasswordNotification,
				true);
	}

	public User changePassword(String password, User user,
			boolean sendChangePasswordNotification,
			boolean enforcePasswordPolicy) throws ValidationFailedException {
		user.setClearTextPassword(password);

		if (enforcePasswordPolicy)
			enforcePasswordPolicy(user);

		if (StringUtils.isBlank(user.getSalt())
				&& StringUtils.isEmpty(user.getSalt())) {
			user.setSalt(ProcnetSecurityUtil.getRandomToken());
		}

		String hashedPassword = ProcnetSecurityUtil.encodeString(user
				.getClearTextPassword() + user.getSalt());

		user.setPassword(hashedPassword);
		user.setDateOfLastPasswordChange(Calendar.getInstance().getTime());
		user.setChangePasswordAtNextLogin(false);

		if (sendChangePasswordNotification
				&& StringUtils.isNotBlank(user.getEmail())) {

			try {
				String message = TemplatingUtils
						.getTemplateString("com/planetsystems/procnet/processes/templates/ForgottenPasswordResponse.tpl");

				HashMap<String, String> placeHolderMap = new HashMap<String, String>();
				placeHolderMap.put(TemplatingEngine.DEFAULT_PLACEHOLDER_NAME,
						user.getUsername());
				placeHolderMap
						.put(TemplatingEngine.DEFAULT_PLACEHOLDER_PASSWORD,
								password);

				message = templatingEngine.process(placeHolderMap, message);

				@SuppressWarnings("deprecation")
				String sourceEmail = ApplicationContextProvider
						.getProperty(
								ProcnetConstants.GLOBAL_PROPERTY_APPLICATION_EMAIL_ADDRESS,
								ProcnetConstants.DEFAULT_FROM_EMAIL_ADDRESS);

				emailService.queueEmail(sourceEmail, user.getEmail(),
						"(ProcNet) Password Change Request", message, true);

			} catch (Exception e) {
				log.error(UserServiceImpl.class.getName(), e);
			}
		}

		return userDao.save(user);
	}

	@Transactional(readOnly = true)
	public int countUsers(Search search) {
		return userDao.count(search);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deactivateUserAccount(User user)
			throws ValidationFailedException, SessionExpiredException {
		User deactivatedUser = getUserById(user.getId());
		
		if(user.getId().contentEquals(ProcnetSecurityUtil.getLoggedInUser().getId())){
			throw new ValidationFailedException("Action not Allowed");
		}
		if (user.getUsername().contentEquals("administrator")) {
			throw new ValidationFailedException(
					"default administrator cannot be deactivated");
		}
		deactivatedUser.setStatus(Boolean.FALSE);
		userDao.save(deactivatedUser);
	}

	@Secured(PermissionConstants.PERM_DELETE_ROLE)
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteRole(Role role) throws OperationFailedException,
			ValidationFailedException {
		if (StringUtils.equalsIgnoreCase(role.getName(),
				Role.DEFAULT_ADMIN_ROLE)) {
			throw new OperationFailedException(
					"cannot delete default administration role");
		}
		/*if (role.getRoleStatus() == RoleStatus.DEFAULT)
			throw new ValidationFailedException("cannot delete default role");*/
		roleDao.remove(role);
	}

	@Secured(PermissionConstants.PERM_DELETE_USER)
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(User user) throws OperationFailedException,
			ValidationFailedException {
		if (user.getUsername().contentEquals("administrator")) {
			throw new ValidationFailedException(
					"cannot delete default administrator");
		}
		userDao.remove(user);
	}

	@Secured(PermissionConstants.PERM_EDIT_ROLES)
	@Transactional(propagation = Propagation.REQUIRED)
	public Role editRole(Role role) throws ValidationFailedException {
		Role rl = getRoleById(role.getId());
		role.setCreatedBy(rl.getCreatedBy());
		role.setDateCreated(rl.getDateCreated());

		if (StringUtils.isBlank(role.getName())
				|| StringUtils.isEmpty(role.getName())) {
			throw new ValidationFailedException(
					"the name of the role is not supplied");
		}

		if (StringUtils.isBlank(role.getDescription())
				|| StringUtils.isEmpty(role.getDescription())) {
			throw new ValidationFailedException(
					"the description of the role is not supplied");
		}

		roleDao.save(role);

		return rl;
	}

	@Secured(PermissionConstants.PERM_EDIT_USERS)
	@Transactional(propagation = Propagation.REQUIRED)
	public User editUser(User user) throws ValidationFailedException {
		User usr = getUserById(user.getId());
		user.setPassword(usr.getPassword());
		user.setSalt(usr.getSalt());
		user.setStatus(usr.getStatus());
		user.setCreatedBy(usr.getCreatedBy());
		user.setDateCreated(usr.getDateCreated());
		enforcePasswordPolicy(usr);

		if (StringUtils.isBlank(getPasswordPolicyString())
				|| StringUtils.isEmpty(getPasswordPolicyString())) {
			throw new ValidationFailedException(
					"the password policy is not set");
		}
		if (StringUtils.isBlank(user.getUsername())
				|| StringUtils.isEmpty(user.getUsername())) {
			throw new ValidationFailedException(
					"the username of the user is not supplied");
		}
		
		if (user.getRoles() == null) {
			throw new ValidationFailedException(
					"the role of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getSecretQuestion())
				|| StringUtils.isEmpty(user.getSecretQuestion())) {
			throw new ValidationFailedException(
					"the secret question of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getSecretAnswer())
				|| StringUtils.isEmpty(user.getSecretAnswer())) {
			throw new ValidationFailedException(
					"the secret answer of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getfName())
				|| StringUtils.isEmpty(user.getfName())) {
			throw new ValidationFailedException(
					"the first name of the user is not supplied");
		}
		if (StringUtils.isBlank(user.getlName())
				|| StringUtils.isEmpty(user.getlName())) {
			throw new ValidationFailedException(
					"the the last of the user is not supplied");
		}
		if (StringUtils.isBlank(user.getEmail())
				|| StringUtils.isEmpty(user.getEmail())) {
			throw new ValidationFailedException(
					"the email of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getPhoneNumber())
				|| StringUtils.isEmpty(user.getPhoneNumber())) {
			throw new ValidationFailedException(
					"the phone number of the user is not supplied");
		}

		userDao.save(user);
		return user;
	}

	@Transactional(readOnly = true)
	private PasswordPolicy getPasswordPolicy() {
		return passwordPolicyDao.searchUniqueByPropertyEqual("status",
				PolicyStatus.ACTIVE);

	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void activatePolicy(PasswordPolicy policy) {
		List<PasswordPolicy> passwordPolicies = new ArrayList<PasswordPolicy>();
		passwordPolicies = passwordPolicyDao.searchByPropertyEqual("status",
				PolicyStatus.ACTIVE);
		for (PasswordPolicy passwordPolicy : passwordPolicies) {
			passwordPolicy.setStatus(PolicyStatus.INACTIVE);
			passwordPolicyDao.save(passwordPolicy);
		}
		policy.setStatus(PolicyStatus.ACTIVE);
		passwordPolicyDao.save(policy);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deletePasswordPolicy(PasswordPolicy policy){
		passwordPolicyDao.remove(policy);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public PasswordPolicy savePasswordPolicy(PasswordPolicy policy)
			throws ValidationFailedException {

		if (StringUtils.isBlank(policy.getPolicy())
				|| StringUtils.isEmpty(policy.getPolicy())) {
			throw new ValidationFailedException(
					"regular expression for the password policy is missing");
		}

		if (policy.getStatus() == null) {
			throw new ValidationFailedException(
					"password policy status is missing");
		}
		return passwordPolicyDao.save(policy);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PasswordPolicy editPasswordPolicy(PasswordPolicy policy)
			throws ValidationFailedException {

		if (StringUtils.isBlank(policy.getPolicy())
				|| StringUtils.isEmpty(policy.getPolicy())) {
			throw new ValidationFailedException(
					"regular expression for the password policy is missing");
		}

		if (policy.getStatus() == null) {
			throw new ValidationFailedException(
					"password policy status is missing");
		}
		return passwordPolicyDao.save(policy);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<PasswordPolicy> getPasswordpolicies() {
		return passwordPolicyDao.searchByRecordStatus(RecordStatus.ACTIVE);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PasswordPolicy getPasswordPolicyById(String id) {
		return passwordPolicyDao.searchUniqueByPropertyEqual("id", id);
	}

	public void enforcePasswordPolicy(User user)
			throws ValidationFailedException {
		/*
		 * enforce password policy (at least 2 numeric characters and a minimum
		 * of 8 characters
		 */
		String regex = getPasswordPolicy().getPolicy();
		if (StringUtils.isNotBlank(user.getClearTextPassword())) {
			if (!user.getClearTextPassword().matches(regex)) {
				throw new ValidationFailedException(
						getPasswordPolicyString());
			}
		}
	}

	@Secured(PermissionConstants.PERM_VIEW_ROLE)
	@Transactional(readOnly = true)
	public List<Role> findRolesByName(String searchString) {
		Search search = new Search();
		search.addFilter(new Filter("name", searchString, Filter.OP_LIKE));
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);
		List<Role> roles = roleDao.search(search);
		return roles;
	}

	@Secured(PermissionConstants.PERM_VIEW_USER)
	@Transactional(readOnly = true)
	public User findUserByUsername(String username) {
		return userDao.searchUniqueByPropertyEqual("username", username);
	}

	@Secured(PermissionConstants.PERM_VIEW_USER)
	@Transactional(readOnly = true)
	public List<User> findUsersByUsername(String username) {
		Search search = new Search();
		search.addFilter(new Filter("username", username, Filter.OP_LIKE));
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);
		List<User> users = userDao.search(search);

		return users;
	}

	public int getNumberOfUsersInSearch(String query) {
		Search search = prepareUserSearchByLoginName(query);
		return userDao.count(search);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Permission getPermissionById(String id) {
		return permissionDao.searchUniqueByPropertyEqual("id", id);
	}

	public List<Permission> getPermissions() {
		List<Permission> permissions = permissionDao
				.searchByRecordStatus(RecordStatus.ACTIVE);
		return permissions;
	}

	@Secured(PermissionConstants.PERM_VIEW_ROLE)
	@Transactional(readOnly = true)
	public Role getRoleById(String id) {
		Role role = roleDao.searchUniqueByPropertyEqual("id", id);
		return role;
	}

	@Secured(PermissionConstants.PERM_VIEW_ROLE)
	@Transactional(readOnly = true)
	public List<Role> getRoles() {
		List<Role> roles = roleDao.searchByRecordStatus(RecordStatus.ACTIVE);
		return roles;
	}

	@Transactional(readOnly = true)
	public List<Role> getRoles(int offset, int limit) {
		Search search = new Search();
		search.addSortAsc("name");
		search.setFirstResult(offset);
		search.setMaxResults(limit);

		return roleDao.search(search);
	}

	@Transactional(readOnly = true)
	public List<Role> getRoles(User user, int offset, int limit) {

		Search search = new Search();
		search.addFilterSome("users", new Filter("name", user));
		search.addSortAsc("name");
		search.setFirstResult(offset);
		search.setMaxResults(limit);

		return roleDao.search(search);
	}

	@Secured(PermissionConstants.PERM_VIEW_ROLE)
	@Transactional(readOnly = true)
	public List<Role> getRolesByPage(Integer pageNo) {
		Search search = new Search();
		search.setMaxResults(ProcnetConstants.MAX_NUM_PAGE_RECORD);
		search.addSort("id", false, true);
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);

		/*
		 * if the page number is less than or equal to zero, no need for paging
		 */
		if (pageNo > 0) {
			search.setPage(pageNo - 1);
		} else {
			search.setPage(0);
		}

		List<Role> roles = roleDao.search(search);
		return roles;
	}

	@Transactional(readOnly = true)
	public int getTotalNumberOfRoles() {
		return roleDao.count(new Search());
	}

	@Transactional(readOnly = true)
	public int getTotalNumberOfRoles(User user) {
		Search search = new Search();
		search.addFilterSome("users", new Filter("", user));
		return roleDao.count(search);
	}

	public int getTotalNumberOfUsers() {
		Search search = new Search();
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);
		return userDao.count(search);
	}

	@Transactional(readOnly = true)
	public User getUserById(String userId) {
		Search search=new Search();
		search.addFilterEqual("id", userId);
		return userDao.searchUnique(search);
	}

	@Transactional(readOnly = true)
	public User getUserByRoleName(String roleName) {
		Search search = new Search();
		search.addFilterSome("roles", Filter.equal("name", roleName));
		return userDao.searchUnique(search);
	}

	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		return userDao.searchUniqueByPropertyEqual("username", username);
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDao;
	}

	@Secured(PermissionConstants.PERM_VIEW_USER)
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		List<User> users = userDao.searchByRecordStatus(RecordStatus.ACTIVE);

		return users;
	}

	@Transactional(readOnly = true)
	public List<User> getUsers(int offset, int limit) {
		Search search = new Search();
		search.addSortAsc("username");
		search.setFirstResult(offset);
		search.setMaxResults(limit);

		return userDao.search(search);
	}

	@Secured(PermissionConstants.PERM_VIEW_USER)
	@Transactional(readOnly = true)
	public List<User> getUsers(Integer pageNo) {
		Search search = new Search();
		search.setMaxResults(ProcnetConstants.MAX_NUM_PAGE_RECORD);
		search.addSort("username", false, true);
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);

		/*
		 * if the page number is less than or equal to zero, no need for paging
		 */
		if (pageNo != null && pageNo > 0) {
			search.setPage(pageNo - 1);
		} else {
			search.setPage(0);
		}

		List<User> users = userDao.search(search);
		return users;
	}

	@Transactional(readOnly = true)
	public List<User> getUsersByRoleName(String roleName) {
		Search search = new Search();
		search.addFilterSome("roles", Filter.equal("name", roleName));
		return userDao.search(search);
	}

	public void savePermision(Permission permission)
			throws ValidationFailedException {
		if (StringUtils.isBlank(permission.getName())
				|| StringUtils.isEmpty(permission.getName())) {
			throw new ValidationFailedException(
					"the name of the permission is not supplied");
		}

		if (StringUtils.isBlank(permission.getDescription())
				|| StringUtils.isEmpty(permission.getDescription())) {
			throw new ValidationFailedException(
					"the description of the permission is not supplied");
		}

		if (StringUtils.isBlank(permission.getId())
				|| StringUtils.isEmpty(permission.getId())) {
			Permission existingPerm = permissionDao
					.searchUniqueByPropertyEqual("name", permission.getName());
			if (existingPerm != null) {
				throw new ValidationFailedException(
						"a permission with the given name already exists");
			}
		}

		permissionDao.save(permission);

	}

	@Secured(PermissionConstants.PERM_SAVE_ROLE)
	@Transactional(propagation = Propagation.REQUIRED)
	public Role saveRole(Role role) throws ValidationFailedException {
		if (StringUtils.isBlank(role.getName())
				|| StringUtils.isEmpty(role.getName())) {
			throw new ValidationFailedException(
					"the name of the role is not supplied");
		}

		if (StringUtils.isBlank(role.getDescription())
				|| StringUtils.isEmpty(role.getDescription())) {
			throw new ValidationFailedException(
					"the description of the role is not supplied");
		}

		if (StringUtils.isBlank(role.getId())
				|| StringUtils.isEmpty(role.getId())) {
			Role existingRole = roleDao.searchUniqueByPropertyEqual("name",
					role.getName());
			if (existingRole != null) {
				throw new ValidationFailedException(
						"a role is the given name already exists");
			}
		}
		Set<Permission> defaultPermission = new HashSet<Permission>();
		defaultPermission
				.add(getPermissionById("BE77AA9B-60CC-47F7-B163-12B0064BE0FA"));
		role.setPermissions(defaultPermission);
		roleDao.save(role);

		return role;
	}

	@Secured(PermissionConstants.PERM_SAVE_USER)
	@Transactional(propagation = Propagation.REQUIRED)
	public User saveUser(User user) throws ValidationFailedException {
		
		
		if (getPasswordPolicy()==null) {
			throw new ValidationFailedException(
					"the password policy is not set");
		}
		
		
		enforcePasswordPolicy(user);
		if (StringUtils.isBlank(user.getUsername())
				|| StringUtils.isEmpty(user.getUsername())) {
			throw new ValidationFailedException(
					"the username of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getClearTextPassword())
				|| StringUtils.isEmpty(user.getClearTextPassword())) {
			throw new ValidationFailedException(
					"the password of the user is not supplied");
		}

		if (user.getRoles() == null) {
			throw new ValidationFailedException(
					"the role of the user is not supplied");
		}
		
		if (StringUtils.isBlank(user.getSecretQuestion())
				|| StringUtils.isEmpty(user.getSecretQuestion())) {
			throw new ValidationFailedException(
					"the secret question of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getSecretAnswer())
				|| StringUtils.isEmpty(user.getSecretAnswer())) {
			throw new ValidationFailedException(
					"the secret answer of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getfName())
				|| StringUtils.isEmpty(user.getfName())) {
			throw new ValidationFailedException(
					"the first name of the user is not supplied");
		}
		if (StringUtils.isBlank(user.getlName())
				|| StringUtils.isEmpty(user.getlName())) {
			throw new ValidationFailedException(
					"the the last of the user is not supplied");
		}
		if (StringUtils.isBlank(user.getEmail())
				|| StringUtils.isEmpty(user.getEmail())) {
			throw new ValidationFailedException(
					"the email of the user is not supplied");
		}

		if (StringUtils.isBlank(user.getPhoneNumber())
				|| StringUtils.isEmpty(user.getPhoneNumber())) {
			throw new ValidationFailedException(
					"the phone number of the user is not supplied");
		}
		// check whether the id is null or empty this is to ensure that the user
		// is new
		if (StringUtils.isBlank(user.getId())
				|| StringUtils.isEmpty(user.getId())) {
			// check whet her username exists
			log.debug(this.getClass().getName()
					+ " - checking for existing user");
			User existingUser = findUserByUsername(user.getUsername());
			if (existingUser != null) {
				throw new ValidationFailedException(
						"a user with this username - " + user.getUsername()
								+ " already exists");
			}

			// by default, the user is set to active
			user.setStatus(Boolean.TRUE);
		} else {
			User existingUser = userDao.find(user.getId());

			if (existingUser != null) {
				user.setPassword(existingUser.getPassword());
				user.setSalt(existingUser.getSalt());
				user.setStatus(existingUser.getStatus());
			}

			User existingUserWithSimilarUsername = findUserByUsername(user
					.getUsername());
			if (!existingUserWithSimilarUsername.getId().equalsIgnoreCase(
					user.getId())) {
				throw new ValidationFailedException(
						"a user with this username - " + user.getUsername()
								+ " already exists");
			}
		}

		// check for clear text password and
		// assign the hashedpassword and the salt from the old object
		ProcnetSecurityUtil.prepUserCredentials(user);
		userDao.save(user);

		return user;
	}

	/**
	 * Search for users
	 */

	@Secured(PermissionConstants.PERM_VIEW_USER)
	@Transactional(readOnly = true)
	public List<User> searchUserByLoginName(String query) {
		Search search = prepareUserSearchByLoginName(query);
		List<User> users = userDao.search(search);
		return users;
	}

	public List<User> searchUserByLoginName(String query, Integer pageNo) {
		Search search = prepareUserSearchByLoginName(query);
		search.setMaxResults(ProcnetConstants.MAX_NUM_PAGE_RECORD);

		if (pageNo != null && pageNo > 0) {
			search.setPage(pageNo - 1);
		} else {
			search.setPage(0);
		}

		List<User> users = userDao.search(search);
		return users;
	}

	@Transactional(readOnly = true)
	public List<User> searchUsers(Search search) {
		return userDao.search(search);
	}

	/**
	 * @param userDAO
	 *            the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDao = userDAO;
	}

	public void validateDisplayAdmin() throws ValidationFailedException,
			SessionExpiredException {
		User user = ProcnetSecurityUtil.getLoggedInUser();
		if (!user.hasPermission(PermissionConstants.PERM_VIEW_ADMINISTRATION)) {
			throw new ValidationFailedException(
					"Access to view Administration not allowed for current user");
		}
	}

	
	@Transactional(readOnly = true)
	public List<User> getUsersByRoleId(String roleId) {
		Search search = new Search();
		search.addFilterSome("roles", Filter.equal("id", roleId));
		search.addFilterEqual("status", Boolean.TRUE);
		return userDao.search(search);
	}

	@Transactional(readOnly = true)
	public User getUserByRoleId(String roleId) {
		Search search = new Search();
		search.addFilterSome("roles", Filter.equal("id", roleId));
		search.addFilterEqual("status", Boolean.TRUE);
		return userDao.searchUnique(search);
	}

	public void genRegex(RegularExpression exp){
		String reg = "^";
		String passPolicy = "The password should have:";
		if(exp.isOnelowerAlphabet()){
			reg = reg +"(?=.*[a-z])";
			passPolicy = passPolicy +" atleast one lowercase alphabet,";
		}
		if(exp.isOneUpperAlphabet()){
			reg = reg +"(?=.*[A-Z])";
			passPolicy = passPolicy +" atleast one Uppercase alphabet,";
		}
		if(exp.isOneNumericValue()){
			reg = reg+"(?=.*[0-9])";
			passPolicy = passPolicy +" atleast one numeric alphabet,";
		}
		if(exp.isOneSpecialChar()){
			reg = reg+"(?=.*[!@#$&*])";
			passPolicy = passPolicy +" atleast one of the following (!@#$&*),";
		}
		if (exp.isLength()){
			
			reg = reg + ".{"+exp.getLowerThreshold()+","+exp.getUpperThreshold()+"}";
			passPolicy = passPolicy +" have not less than "+exp.getLowerThreshold()+" and not more than "+exp.getUpperThreshold()+" characters";
		}
		reg = reg + "$";
		passPolicy = passPolicy +".";
		PasswordPolicy policy = new PasswordPolicy();
		policy.setPolicy(reg);
		policy.setPolicyString(passPolicy);
		activatePolicy(policy);
		try {
			savePasswordPolicy(policy);
		} catch (ValidationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*@Transactional(readOnly = true)
	public List<String> userCatergories() {
		List<String> status = new ArrayList<String>();
		for (UserCatergory lin : UserCatergory.values()) {
			status.add(lin.getUserCatergory());
		}
		return status;
	}*/
	
	/*@Transactional(readOnly = true)
	public List<String> roleStatuses() {
		List<String> status = new ArrayList<String>();
		for (RoleStatus lin : RoleStatus.values()) {
			status.add(lin.getRoleStatus());
		}
		return status;
	}*/
	
	@Transactional(readOnly = true)
	public String getPasswordPolicyString() {
		return passwordPolicyDao.searchUniqueByPropertyEqual("status",
				PolicyStatus.ACTIVE).getPolicyString();

	}

	public void validateDisplayBudget() throws ValidationFailedException,
			SessionExpiredException {
		// TODO Auto-generated method stub
		
	}

	

}
