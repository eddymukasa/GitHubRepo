package com.eddy.cribz.bookingSystem.core.service;

import java.util.List;

import com.eddy.cribz.bookingSystem.model.Booking;
import com.eddy.cribz.bookingSystem.model.Category;
import com.eddy.cribz.bookingSystem.model.Event;
import com.eddy.cribz.bookingSystem.model.exceptions.ValidationFailedException;

public interface BookingService {

	Booking saveBooking(Booking booking) throws ValidationFailedException;
	
	Booking editBooking(Booking booking) throws ValidationFailedException;
	
	void deleteBooking(Booking booking);
	
	List<Booking> getBookings();
	
	List<Booking> getBookingsByUser();
	
	Booking getBookingById(String id);
	
	Booking getBookingByRefNo(String refNo);
	
	Event saveEvent(Event event)throws ValidationFailedException;
	
	Event editEvent(Event event)throws ValidationFailedException;
	
	void deleteEvent(Event event);
	
	List<Event> getEvents();
	
	Event getEventsByBookingRefNo(String refNo);
	
	Event getEventById(String id);
	
	List<Event> getEventsByCategory(Category category);
	
	
	
}
