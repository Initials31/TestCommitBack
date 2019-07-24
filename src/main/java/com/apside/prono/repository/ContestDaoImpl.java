package com.apside.prono.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.apside.prono.model.Contest;

public class ContestDaoImpl implements ContestDao {
	
	@PersistenceContext
	private EntityManager em;

	public ContestDaoImpl() {
	}

	public ContestDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Contest create(Contest c) {
		this.em.persist(c);
		return c;
	}
	
	@Override
	public List<Contest> getAllContests() {
		return this.em.createQuery("select c from Contest c", Contest.class)
				.getResultList();
	}

	@Override
	public Contest getContestById(long id) {
		return this.em.find(Contest.class, id);
	}
	

}
