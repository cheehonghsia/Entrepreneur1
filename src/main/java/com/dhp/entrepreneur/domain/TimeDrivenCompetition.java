package com.dhp.entrepreneur.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * TimeDrivenCompetition is a subclass from the superclass Competition.
 * Time-driven competition means that the competition will start and end at a pre-defined date.
 * Once the end date is reached, the winner will be the participant who has gathered the most earned points. 
 */

@Entity
@DiscriminatorValue("TIME_DRIVEN")
public class TimeDrivenCompetition extends Competition {
	
	private Date startDate;
	private Date endDate;
	
	/** Default constructor for Hibernate */	
	public TimeDrivenCompetition() {
		super();
	}
	
	/**
	 * 
	 * @param name - name of the competition.
	 * @param earningPoint - how much points can a participant earn when he/she finished the project.
	 */
	public TimeDrivenCompetition(String name, Date startDate, Date endDate, List<Project> projects, Company company, Status status) {
		super(name, projects, company, status);
		this.startDate = startDate;
		this.endDate = endDate;
		}
	
	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name="END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
