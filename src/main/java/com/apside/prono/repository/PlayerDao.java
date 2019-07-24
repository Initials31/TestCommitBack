package com.apside.prono.repository;

import java.util.List;

import com.apside.prono.model.Player;

public interface PlayerDao {
	
	Player create(Player p);
	
	List<Player> getAllPlayers();
	
	Player getById(long id);
	
	void delete(long id);

}
