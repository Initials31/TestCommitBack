package com.apside.prono.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apside.prono.model.Contest;
import com.apside.prono.repository.ContestDao;

@Service
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
	
	@Override
	@Transactional
	public Contest update(Contest c) {
		Contest contest = contestDao.getContestById(c.getId());
		contest.setLabel(c.getLabel());
		return contest;
	}
	
	@Override
	@Transactional
	public void deleteContest(long id) {
		contestDao.deleteContest(id);
	}



}
