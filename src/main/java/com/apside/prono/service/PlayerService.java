package com.apside.prono.service;

import java.util.List;

import com.apside.prono.errors.PlayerInconnuException;
import com.apside.prono.model.Player;

public interface PlayerService {
	Player getById(long id) throws PlayerInconnuException;
	Player create(Player player);
	List<Player> getAllPlayers();
	void delete(long id);

}
