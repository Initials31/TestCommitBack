package com.apside.prono.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.apside.prono.model.Contest;
import com.apside.prono.repository.ContestDao;

public class ContestServiceImpl implements ContestService {
	
private ContestDao contestDao;
	
	public ContestServiceImpl(@Autowired ContestDao contestDao) {
		this.contestDao = contestDao;
	}
	
	@Override
	@Transactional
	public Contest create(Contest c) {
		Contest contest = contestDao.create(c);
		return contest;
	}
	
	@Override
	public List<Contest> getAllContests() {
		List<Contest> contests = contestDao.getAllContests();
		return contests;
	}

	@Override
	public Contest getContestById(long id) {
		Contest contest = contestDao.getContestById(id);
		return contest;
	}


}