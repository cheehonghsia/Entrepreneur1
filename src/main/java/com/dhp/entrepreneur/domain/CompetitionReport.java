package com.dhp.entrepreneur.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>@author Chee-Hong Hsia </b><br> 
 * The CompetitionReport class represents the progress of each users relatively from each other. 
 * Via the CompetitionReport class you can retrieve the participants current competition status. 
 */
@Entity
@Table(name="COMPETITION_REPORT")
public class CompetitionReport {
	
	private long id;
	private int points;
	
	/** Default constructor for Hibernate */	
	public CompetitionReport() {
		super();
	}
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="POINTS")
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
