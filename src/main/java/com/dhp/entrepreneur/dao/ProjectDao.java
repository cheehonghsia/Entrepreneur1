package com.dhp.entrepreneur.dao;

import java.util.List;

import com.dhp.entrepreneur.domain.Project;

public interface ProjectDao {

	/**
	 * Method to save a project
	 * @param projects
	 */
	public void create(Project project);
	
	/**
	 * This method method returns a list of Own project objects.
	 * @param id
	 * @param department
	 * @return a list of own projects created by the participant
	 */
	public List<Project> getAllOwnProjects(long id, String department);
	
	/**
	 * Method to get all projects that does not have points assigned.
	 * @param companyID
	 * @param department
	 * @return a list of project objects where no points are assigned.
	 */
	public List<Project> getAllWithNoPoints(long companyID, String department);
	
	/**
	 * Method to get all projects that does  have  points assigned.
	 * @param companyID
	 * @param department
	 * @return a list of project objects where points are assigned.
	 */
	public List<Project> getAllWithPoints(long companyID, String department);
	
	/**
	 * Method to modify a project.
	 * @param project
	 */
	public void update(Project project);
	
	/**
	 * Method to retrieve an unique project based on projectID.
	 * @param project
	 * @return an unique project object.
	 */
	public Project get(long  projectID);
	
	/**
	 * Method to delete a project.
	 * @param project
	 */
	public void delete(Project project);
}
