package com.apside.prono.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apside.prono.model.Event;
import com.apside.prono.repository.EventDao;

@Service
public class EventServiceImpl implements EventService {
	
	private EventDao eventDao;
	
	public EventServiceImpl(@Autowired EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	@Override
	@Transactional
	public Event create(Event e) {
		Event event = eventDao.create(e);
		return event;
	}
	
	@Override
	public List<Event> getAllEvents() {
		List<Event> events = eventDao.getAllEvents();
		return events;
	}

	@Override
	public Event getEventById(long id) {
		Event event = eventDao.getEventById(id);
		return event;
	}
	
	@Override
	@Transactional
	public Event update(Event e) {
		Event event = eventDao.getEventById(e.getId());
		event.setLabel(e.getLabel());
		event.setEventDate(e.getEventDate());
		event.setOpenDate(e.getOpenDate());
		event.setCloseDate(e.getCloseDate());
		event.setCoeff(e.getCoeff());
		return event;
	}
	
	@Override
	@Transactional
	public void deleteEvent(long id) {
		eventDao.deleteEvent(id);
	}

}
