package com.eddy.cribz.bookingSystem.core.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.eddy.cribz.bookingSystem.core.security.ProcnetUserDetails;
import com.eddy.cribz.bookingSystem.model.User;



public interface ProcnetUserDetailsService extends UserDetailsService {

	ProcnetUserDetails getUserDetailsForUser(User user);
}
