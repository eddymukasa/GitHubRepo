package com.eddy.cribz.bookingSystem.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.UserDAO;
import com.eddy.cribz.bookingSystem.model.User;


@Repository("Userdao")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

}
