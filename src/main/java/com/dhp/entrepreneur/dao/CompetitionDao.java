package com.dhp.entrepreneur.dao;

import java.util.List;

import com.dhp.entrepreneur.domain.Competition;
import com.dhp.entrepreneur.domain.Project;

public interface CompetitionDao {

	/**
	 * Method to save a competition.
	 * @param competition
	 */
	public void create(Competition competition);
	
	/**
	 * Method to get all competition within a specific company (companyID) and department.
	 * @param companyID
	 * @param department
	 * @return
	 */
	public List<Competition> getAll(long companyID, String department);
	
	/**
	 * Method to modify a competition.
	 * @param competition
	 */
	public void update(Competition competition);
	
	/**
	 * Method to delete  a competition.
	 * @param competition
	 */
	public void delete(Competition competition);
	
	/**
	 * Method to check if a Competition contains 1 or more projects.
	 * @return true if the Competition contains 1 or more projects
	 */
	public boolean hasProjects(long competitionID);
	
	/**
	 * Method to add 1 or multiple projects within a Competition.
	 * @param competition
	 * @param projects
	 */
	public void addProject(Competition competition,  List<Project> projects);
	
	/**
	 * Method to remove 1 or multiple projects within a Competition.
	 * @param competition
	 * @param projects
	 */
	public void removeProject(Competition competition,  List<Project> projects);
}
