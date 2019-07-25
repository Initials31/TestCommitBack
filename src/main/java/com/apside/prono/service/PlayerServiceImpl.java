package com.apside.prono.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apside.prono.errors.PlayerInconnuException;
import com.apside.prono.model.Player;
import com.apside.prono.repository.PlayerDao;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	
	private PlayerDao playerDao;

	public PlayerServiceImpl(@Autowired PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	@Transactional
	public Player create(Player p) {
		Player player = playerDao.create(p);
		return player;
	}
	
	@Override
	public List<Player> getAllPlayers() {
		List<Player> players = playerDao.getAllPlayers();
		return players;
	}

	@Override
	public Player getById(long id) throws PlayerInconnuException {
		Player player = playerDao.getById(id);
		if (player == null) {
			throw new PlayerInconnuException(id);
		}
		return player;
	}
	
	@Override
	@Transactional
	public Player update(Player p) {
		Player player = playerDao.getById(p.getId());
		player.setFirstName(p.getFirstName());
		player.setLastName(p.getLastName());
		player.setMail(p.getMail());
		player.setSubscriptionDate(p.getSubscriptionDate());
		return player;
	}

	@Override
	@Transactional
	public void deletePlayer(long id) {
		playerDao.deletePlayer(id);
	}
	

}
