package com.dhp.entrepreneur.service;

import com.dhp.entrepreneur.domain.PredefinedProject;
import com.dhp.entrepreneur.domain.Project;

public interface ProjectService {
	
	/**
	 * Method to save 1 of more projects.
	 * @param projects
	 */
	public void save(Project projects);

	/**
	 * Method for creating a project.
	 * @param predefinedProject
	 */
	public void create(PredefinedProject predefinedProject);

}
