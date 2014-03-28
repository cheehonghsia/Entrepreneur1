package com.dhp.entrepreneur.service;

import java.util.List;

import com.dhp.entrepreneur.domain.Competition;



/**
 * @author Chee-Hong Hsia
 * Service layer (facade) where business logics are applied.
 */
public interface CompetitionService {
	
	/**
	 * Method for creating a competition.
	 * @param competition
	 */
	public void createCompetition(Competition competition);
	
	/**
	 * Method for returning a list of Competitions based on the company and department.
	 * @param companyID
	 * @param department
	 * @return a list of Competitions within a company and department.
	 */
	public List<Competition> get(long companyID, String department);

}
