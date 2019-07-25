package com.apside.prono.repository;

import java.util.List;

import com.apside.prono.model.Event;

public interface EventDao {

	Event create(Event e);

	List<Event> getAllEvents();

	Event getEventById(long id);

	void deleteEvent(long id);

}
