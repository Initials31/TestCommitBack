package com.apside.prono.service;

import java.util.List;


import com.apside.prono.model.Player;

public interface PlayerService {
	
	Player create(Player player);
	List<Player> getAllPlayers();

}
