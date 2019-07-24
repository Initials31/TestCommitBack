package com.apside.prono.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.apside.prono.model.Event;

public class EventDaoImpl implements EventDao {
	
	@PersistenceContext
	private EntityManager em;

	public EventDaoImpl() {
	}

	public EventDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Event create(Event e) {
		this.em.persist(e);
		return e;
	}
	
	@Override
	public List<Event> getAllEvents() {
		return this.em.createQuery("select e from Event e", Event.class)
				.getResultList();
	}

	@Override
	public Event getEventById(long id) {
		return this.em.find(Event.class, id);
	}
	
	
	
	

}
