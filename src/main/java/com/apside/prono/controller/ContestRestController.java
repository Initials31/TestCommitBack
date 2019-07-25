package com.apside.prono.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apside.prono.model.Contest;
import com.apside.prono.service.ContestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContestRestController {
	
	@Autowired
	private ContestService contestService;
	
	@GetMapping(produces = "application/json", path = "/api/contest")
	public ResponseEntity<List<Contest>> getAllContests() {	
		List<Contest> contests = contestService.getAllContests();
		return ResponseEntity.ok().body(contests);
	}
	
	@GetMapping(produces = "application/json", path="/api/contest/{id}")
	public ResponseEntity<Contest> getContestById(@PathVariable long id) {
		Contest contest = contestService.getContestById(id);
		return ResponseEntity.ok().body(contest);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json", path = "/api/contest")
	public ResponseEntity<Contest> create(@RequestBody Contest c, UriComponentsBuilder uriBuilder) {
		contestService.create(c);
		URI location = uriBuilder.path("/api/contest/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(location).body(c);	
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json", path = "/api/contest")
	public Contest update(@RequestBody Contest c) {
		return contestService.update(c);
	}
	
	@DeleteMapping("/api/contest/{id}")
	public void deleteContest(@PathVariable long id) {
		contestService.deleteContest(id);
	}

}
