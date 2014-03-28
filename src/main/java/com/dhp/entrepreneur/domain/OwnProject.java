package com.dhp.entrepreneur.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * Ownproject are projects that are putted forward by the participant him/herself. 
 * Due to the entrepreneurial characteristic of this event, the participant will be rewarded. 
 * 
 */
@Entity
@DiscriminatorValue("OWN_PROJECT")
public class OwnProject extends Project {
	
	private int bonus = 2;
	
	/** Default constructor for Hibernate */	
	@SuppressWarnings("unused")
	private OwnProject() {
		super();
	}

	/**
	 * OwnProject constructor which accepts the following parameters:
	 * Participants who presents their own project aren't able to insert any point nor active the project. This needs to be done by the mentor.
	 * @param name - name of the project.
	 * @param description - projects description.
	 */
	public OwnProject(String name, String description, Company company) {
		super(name, description, 0, false, company);
	}
	
	/**
	 * Retrieve the calculated reward for initializing an own project. 
	 * The calculation of the reward is currently a factor 2 of the project point.
	 */
	public int retrieveBonuspoint(){
		return super.point * this.bonus;
	}
}
