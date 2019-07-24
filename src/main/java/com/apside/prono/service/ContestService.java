package com.apside.prono.service;

import java.util.List;

import com.apside.prono.model.Contest;

public interface ContestService {

	Contest create(Contest c);

	List<Contest> getAllContests();

	Contest getContestById(long id);

}
