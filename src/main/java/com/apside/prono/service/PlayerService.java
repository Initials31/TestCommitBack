package com.apside.prono.service;

import java.util.List;

import com.apside.prono.errors.PlayerInconnuException;
import com.apside.prono.model.Player;

public interface PlayerService {
	
	Player create(Player player);
	
	List<Player> getAllPlayers();
	
	Player getById(long id) throws PlayerInconnuException;

	Player update(Player p);

	void deletePlayer(long id);

}
