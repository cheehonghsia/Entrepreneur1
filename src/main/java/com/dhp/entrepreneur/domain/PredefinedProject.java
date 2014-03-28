package com.dhp.entrepreneur.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PREDEFINED_PROJECT")
public class PredefinedProject extends Project {
	
	/** Default constructor for Hibernate */
	public PredefinedProject() {
		super();
	}

	/**
	 * PredefinedProject constructor which accepts the following parameters:
	 *  Note that a predefined project is always active.
	 * @param name - name of the project.
	 * @param description - projects description.
	 * @param point - indicate how much point this project is worth.
	 * @param isActive - yes indicates that the project is active.
	 */
	public PredefinedProject(String name, String description, int point, Company company) {
		super(name, description, point, true, company);
	}
	
	/**
	 * PredefinedProject constructor which accepts the following parameters:
	 *  Note that a predefined project is always active.
	 * @param name - name of the project.
	 * @param description - projects description.
	 * @param isActive - yes indicates that the project is active.
	 */
	public PredefinedProject(String name, String description, Company company) {
		super(name, description, 0, true, company);
	}
}
