package com.apside.prono.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.apside.prono.model.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	@PersistenceContext
	private EntityManager em;

	public PlayerDaoImpl() {
	}

	public PlayerDaoImpl(EntityManager em) {
		this.em = em;
	}

	
	@Override
	public Player create(Player p) {
		this.em.persist(p);
		return p;
	}
	
	@Override
	public List<Player> getAllPlayers() {
		return this.em.createQuery("select p from Player p", Player.class)
				.getResultList();
	}

}
