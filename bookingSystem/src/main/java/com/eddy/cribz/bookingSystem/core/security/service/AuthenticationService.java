package com.eddy.cribz.bookingSystem.core.security.service;

import com.eddy.cribz.bookingSystem.model.User;



public interface AuthenticationService {

	User authenticate(String username, String password,
			boolean attachUserToSecurityContext);

	Boolean isValidUserPassword(User user, String loginPassword);

	boolean isEnabledUser(User systemUser);

}
