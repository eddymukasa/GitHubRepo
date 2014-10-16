package com.eddy.cribz.bookingSystem.core.service.Impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.eddy.cribz.bookingSystem.core.dao.BookingDAO;
import com.eddy.cribz.bookingSystem.core.dao.EventsDAO;
import com.eddy.cribz.bookingSystem.core.email.EmailService;
import com.eddy.cribz.bookingSystem.core.service.BookingService;
import com.eddy.cribz.bookingSystem.model.Booking;
import com.eddy.cribz.bookingSystem.model.Category;
import com.eddy.cribz.bookingSystem.model.Event;
import com.eddy.cribz.bookingSystem.model.RecordStatus;
import com.eddy.cribz.bookingSystem.model.exceptions.ValidationFailedException;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

public class BookingServiceImpl implements BookingService{
	
	
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EventsDAO	eventsDao;
	
	@Autowired
	private BookingDAO	bookingDao;

	public void validateEvent(Event event) throws ValidationFailedException{
		
		if (StringUtils.isBlank(event.getLocation())
				|| StringUtils.isEmpty(event.getLocation())) {
			throw new ValidationFailedException(
					"Please enter the location of the event");
		}
		
		if (StringUtils.isBlank(event.getCategory().toString())
			|| StringUtils.isEmpty(event.getCategory().toString())){
			throw new ValidationFailedException(
					"Please enter the category of the event");
		}
		
		if (event.getDate() == null){
			throw new ValidationFailedException(
					"Please select the date of the event");
		}
		
		if (event.getTime() == null){
			throw new ValidationFailedException(
					"Please select the time of the event");
		}
	}

	public void validateBooking(Booking booking) throws ValidationFailedException{
		
		
		if (StringUtils.isBlank(booking.getReferenceNo())
				|| StringUtils.isEmpty(booking.getReferenceNo())){
				throw new ValidationFailedException(
						"This booking is missing a reference number");
			}
		
		if (booking.getEvent() == null){
			throw new ValidationFailedException(
					"This booking is not attached to an event");
		}
		
		if (booking.getUser() == null){
			throw new ValidationFailedException(
					"This booking is not attached to a user");
		}
	}
	
	public Booking saveBooking(Booking booking) throws ValidationFailedException {
		
		validateBooking(booking);
		bookingDao.save(booking);
		return booking;
	}

	public Booking editBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingDao.remove(booking);
		
	}

	public List<Booking> getBookings() {
		List<Booking> bookings = bookingDao.searchByRecordStatus(RecordStatus.ACTIVE);
		return bookings;
	}

	public List<Booking> getBookingsByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Booking getBookingById(String id) {
		Booking booking = bookingDao.searchUniqueByPropertyEqual("id", id);
		return booking;
	}

	public Booking getBookingByRefNo(String refNo) {
		Booking booking = bookingDao.searchUniqueByPropertyEqual("referenceNo", refNo);
		return booking;
	}

	public Event saveEvent(Event event) throws ValidationFailedException {
		
		validateEvent(event);
		eventsDao.save(event);
		return event;
	}

	public Event editEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEvent(Event event) {
		
		eventsDao.remove(event);
		
	}

	public List<Event> getEvents() {
		List<Event> events = eventsDao.searchByRecordStatus(RecordStatus.ACTIVE);
		return events;
	}

	public Event getEventsByBookingRefNo(String refNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event getEventById(String id) {
		Event event = eventsDao.searchUniqueByPropertyEqual("id", id);
		return event;
	}

	public List<Event> getEventsByCategory(Category category) {
		Search search = new Search();
		search.addFilterSome("category", Filter.equal("category", category.toString()));
		return eventsDao.search(search);
	}

}
