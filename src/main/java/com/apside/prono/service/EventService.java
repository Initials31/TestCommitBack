package com.apside.prono.service;

import java.util.List;

import com.apside.prono.model.Event;

public interface EventService {

	Event create(Event e);

	List<Event> getAllEvents();

	Event getEventById(long id);

}
