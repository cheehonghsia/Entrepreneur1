package com.dhp.entrepreneur.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * The Competition class is the superclass of all different type of competitions available.  
 * Before a contest can start, the mentor who is also the administrator should create a specific type of 
 * competition. Once a competition has been created, 1 or many projects can be added. 
 * If needed, a mentor can also create multiple competitions and assign projects to it.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="COMPETITION_TYPE", discriminatorType=DiscriminatorType.STRING)
@Table(name="COMPETITION")
public abstract class Competition {
	
	protected long id;
	protected String name;
	protected List<Project> projects;
	protected Company company;
	protected Status status;

	/** Default constructor for Hibernate */	
	protected Competition() {
		super();
	}
	
	protected Competition(String name, List<Project> projects, Company company, Status status) {
		this.name = name;
		this.projects = projects;
		this.company = company;
		this.status = status;
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
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@OneToOne(cascade={CascadeType.PERSIST})
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name="STATUS")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
