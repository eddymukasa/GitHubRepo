package com.eddy.cribz.bookingSystem.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.RoleDAO;
import com.eddy.cribz.bookingSystem.model.Role;



@Repository("Roledao")
public class RoleDAOImpl extends BaseDAOImpl<Role> implements RoleDAO{

}
