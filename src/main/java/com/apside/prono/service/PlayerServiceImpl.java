package com.apside.prono.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apside.prono.model.Player;
import com.apside.prono.repository.PlayerDao;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	
	private PlayerDao playerDao;

	public PlayerServiceImpl(@Autowired PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Transactional
	@Override
	public Player create(Player p) {
		Player player = playerDao.create(p);
		return player;
	}
	
	
	@Override
	public List<Player> getAllPlayers() {
		List<Player> players = playerDao.getAllPlayers();
		return players;
	}
	

}
