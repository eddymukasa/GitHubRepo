package com.eddy.cribz.bookingSystem.model;

import javax.persistence.Entity;

@Entity
public class PasswordPolicy extends ParentEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4614754425233159760L;

	private String policy ;
	private PolicyStatus status;
	private String policyString;
	
	public PasswordPolicy() {
		super();
	}

	public PasswordPolicy(String policy) {
		super();
		this.setPolicy(policy);
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public PolicyStatus getStatus() {
		return status;
	}

	public void setStatus(PolicyStatus stasus) {
		this.status = stasus;
	}

	public String getPolicyString() {
		return policyString;
	}

	public void setPolicyString(String policyString) {
		this.policyString = policyString;
	}
	
	
	
}
