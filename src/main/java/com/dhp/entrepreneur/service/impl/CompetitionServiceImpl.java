package com.dhp.entrepreneur.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhp.entrepreneur.dao.CompetitionDao;
import com.dhp.entrepreneur.domain.Competition;
import com.dhp.entrepreneur.service.CompetitionService;

@Component
public class CompetitionServiceImpl implements CompetitionService {
	
	@Autowired private CompetitionDao competitionDao; 

	@Override
	public void createCompetition(Competition competition) {
		this.competitionDao.create(competition);
	}
	
	@Override
	public List<Competition> get(long companyID, String department){
		return this.competitionDao.getAll(companyID, department);
	}
}
