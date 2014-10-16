package com.eddy.cribz.bookingSystem.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.EventsDAO;
import com.eddy.cribz.bookingSystem.model.Event;

@Repository("EventsDAO")
public class EventsDAOImpl extends BaseDAOImpl<Event> implements EventsDAO{

}
