package com.apside.prono.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apside.prono.model.Event;
import com.apside.prono.service.EventService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventRestController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping(produces = "application/json", path = "/api/events")
	public ResponseEntity<List<Event>> getAllEvents() {	
		List<Event> events = eventService.getAllEvents();
		return ResponseEntity.ok().body(events);
	}
	
	@GetMapping(produces = "application/json", path="/api/event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable long id) {
		Event event = eventService.getEventById(id);
		return ResponseEntity.ok().body(event);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json", path = "/api/event")
	public ResponseEntity<Event> create(@RequestBody Event e, UriComponentsBuilder uriBuilder) {
		eventService.create(e);
		URI location = uriBuilder.path("/api/event/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(location).body(e);	
	}

}
