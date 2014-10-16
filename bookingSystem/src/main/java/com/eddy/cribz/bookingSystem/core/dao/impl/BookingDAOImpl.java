package com.eddy.cribz.bookingSystem.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.BookingDAO;
import com.eddy.cribz.bookingSystem.model.Booking;

@Repository("BookingDAO")
public class BookingDAOImpl extends BaseDAOImpl<Booking>implements BookingDAO {

}
