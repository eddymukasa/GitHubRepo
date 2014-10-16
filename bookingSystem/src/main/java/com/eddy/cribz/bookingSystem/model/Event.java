package com.eddy.cribz.bookingSystem.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Event")
public class Event extends ParentEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853018666126150670L;

	private Category category;
	private String categoryDesc;
	private String location;
	private Date date;
	private Time time;
	private Booking booking;
	
	
	
	public Event() {
		super();
	}
	
	
	public Event(Category category, String categoryDesc, String location,
			Date date, Time time, Booking booking) {
		super();
		this.category = category;
		this.categoryDesc = categoryDesc;
		this.location = location;
		this.date = date;
		this.time = time;
		this.booking = booking;
	}


	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	@OneToOne(mappedBy = "event")
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
