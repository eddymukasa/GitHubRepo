package com.eddy.cribz.bookingSystem.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.PasswordPolicyDAO;
import com.eddy.cribz.bookingSystem.model.PasswordPolicy;


@Repository("PasswordPolicydao")
public class PasswordPolicyDAOImpl extends BaseDAOImpl<PasswordPolicy> implements PasswordPolicyDAO{

}
