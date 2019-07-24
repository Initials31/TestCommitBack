package com.apside.prono.repository;

import java.util.List;

import com.apside.prono.model.Contest;

public interface ContestDao {

	Contest create(Contest c);

	List<Contest> getAllContests();

	Contest getContestById(long id);

}
