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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apside.prono.errors.PlayerInconnuException;
import com.apside.prono.model.Player;
import com.apside.prono.service.PlayerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerRestController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping(produces = "application/json", path = "/api/players")
	public ResponseEntity<List<Player>> getAllPlayers() {	
		List<Player> players = playerService.getAllPlayers();
		return ResponseEntity.ok().body(players);
	}
	
	@GetMapping(produces = "application/json", path="/api/player/{id}")
	public ResponseEntity<Player> getById(@PathVariable long id) throws PlayerInconnuException{
		Player player = playerService.getById(id);
		return ResponseEntity.ok().body(player);
	}
	
	
	@PostMapping(consumes = "application/json", produces = "application/json", path = "/api/player")
	public ResponseEntity<Player> create(@RequestBody Player p, UriComponentsBuilder uriBuilder) {
		playerService.create(p);
		URI location = uriBuilder.path("/api/player/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(location).body(p);	
	}
	
	
	
	
	@DeleteMapping("/api/player/{id}")
	public void deletePlayer(@PathVariable long id) {
		playerService.delete(id);
	}
}
