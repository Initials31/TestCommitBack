package com.apside.prono.repository;

import java.util.List;

import com.apside.prono.model.Player;

public interface PlayerDao {
	
	Player getById(long id);
	Player create(Player p);
	List<Player> getAllPlayers();
	void delete(long id);

}
