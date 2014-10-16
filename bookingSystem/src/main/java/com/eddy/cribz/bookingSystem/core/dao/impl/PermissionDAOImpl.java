package com.eddy.cribz.bookingSystem.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.PermissionDAO;
import com.eddy.cribz.bookingSystem.model.Permission;



@Repository("Permissiondao")
public class PermissionDAOImpl extends BaseDAOImpl<Permission> implements PermissionDAO{

}
