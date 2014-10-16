package com.eddy.cribz.bookingSystem.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking extends ParentEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String referenceNo;
	private String additionalInfo;
	
	private User user;
	private Event event;
	
	
	
	public Booking() {
		super();
	}
	
	
	public Booking(String referenceNo, String additionalInfo, User user,
			Event event) {
		super();
		this.referenceNo = referenceNo;
		this.additionalInfo = additionalInfo;
		this.user = user;
		this.event = event;
	}


	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne
	@JoinColumn(name="Event_Id")
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

}
