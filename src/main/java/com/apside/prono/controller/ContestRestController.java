package com.apside.prono.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apside.prono.model.Contest;
import com.apside.prono.service.ContestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContestRestController {
	
	@Autowired
	private ContestService contestService;
	
	@GetMapping(produces = "application/json", path = "/api/contests")
	public ResponseEntity<List<Contest>> getAllContests() {	
		List<Contest> contests = contestService.getAllContests();
		return ResponseEntity.ok().body(contests);
	}
	
	@GetMapping(produces = "application/json", path="/api/contest/{id}")
	public ResponseEntity<Contest> getContestById(@PathVariable long id) {
		Contest contest = contestService.getContestById(id);
		return ResponseEntity.ok().body(contest);
	}

}
