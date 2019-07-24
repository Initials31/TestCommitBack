package com.apside.prono.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apside.prono.model.Player;
import com.apside.prono.service.PlayerService;

@RestController
public class PlayerRestController {
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping(consumes = "application/json", produces = "application/json", path = "/api/creerPlayer")
	public ResponseEntity<Player> create(@RequestBody Player p) {
		Player player = playerService.create(p);
		return ResponseEntity.ok().body(player);	
	}
	

	@GetMapping(produces = "application/json", path = "/api/players")
	public ResponseEntity<List<Player>> getAllPlayers() {	
		List<Player> players = playerService.getAllPlayers();
		return ResponseEntity.ok().body(players);
	}
	

}
