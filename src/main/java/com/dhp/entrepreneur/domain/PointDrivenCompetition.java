package com.dhp.entrepreneur.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * PointDrivenCompetition is a subclass from the superclass Competition.
 * Point-driven competition means that the competition will end once a pre-defined total amount of points has been met. 
 * The participant that reached the defined total point first will win the competition. 
 */
@Entity
@DiscriminatorValue("POINT_DRIVEN")
public class PointDrivenCompetition extends Competition {

	private int endPoint; //this represents the point that needs to be reach for the participant to win the competition.
	
	/** Default constructor for Hibernate */		
	@SuppressWarnings("unused")
	private PointDrivenCompetition() {
		super();
	}

	/**
	 * Constructor with the following parameters:
	 * @param name - name of the competition.
	 * @param endPoint - how much points can a participant earn when he/she finished the project.
	 * @param projects - list of projects that needs to be added in the competition.
	 * @param company
	 * @param status
	 */
	public PointDrivenCompetition(String name, int endPoint, List<Project> projects, Company company, Status status) {
		super(name, projects, company, status);
		this.endPoint = endPoint;
	}
	
	@Column(name="END_POINT")
	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
}
