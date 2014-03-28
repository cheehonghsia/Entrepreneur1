package com.dhp.entrepreneur.scheduler.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhp.entrepreneur.dao.CompetitionDao;
import com.dhp.entrepreneur.scheduler.CompetitionScheduler;

@Component
public class CompetitionSchedulerImpl implements CompetitionScheduler {
	
	@Autowired CompetitionDao competitionDao;

	@Override
	public void activateCompetition(){
		
		// 1. Retrieve all Competition within this application.
		// 2. Check whether the start date of the retrieved Competition equals OR smaller than today.
		// 3. If yes, set the isActive flag to true.
		
		System.out.println(new Date());
	}
	
	@Override
	public void endCompetition(){
		
		// 1. Retrieve all Competition within this application.
		// 2. Check whether the start date of the retrieved Competition equals OR smaller than today.
		// 3. If yes, set the isActive flag to true.
		
		System.out.println(new Date());
	}
	
}
