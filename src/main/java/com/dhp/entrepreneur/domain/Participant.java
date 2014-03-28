package com.dhp.entrepreneur.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * Participant is the subclass of the abstract User superclass.
 * A participant is a contestant of this software.
 */
@Entity
public class Participant extends User {

	/** each participant object stores its overall earning points. Once a project is completed, the project 
	 * points will be added onto the overallPoint.*/
	private int overallPoint; 
	private List<CompetitionReport> competitionReports;

	/** Default constructor for Hibernate */
	@SuppressWarnings("unused")
	private Participant() {
		super();
	}
	
	public Participant(String name, String surname, String emailaddress, Company company) {
		super();
		super.name = name;
		super.surname = surname;
		super.email = emailaddress;
		super.company = company;
	}

	@Column(name="OVERALL_POINT")
	public int getOverallPoint() {
		return overallPoint;
	}
	
	public void setOverallPoint(int overallPoint) {
		this.overallPoint = overallPoint;
	}
	
	@OneToMany
	@JoinColumn(name="PARTICIPANT_ID")
	public List<CompetitionReport> getCompetitionReports() {
		return competitionReports;
	}
	
	public void setCompetitionReports(List<CompetitionReport> competitionReports) {
		this.competitionReports = competitionReports;
	}
}
