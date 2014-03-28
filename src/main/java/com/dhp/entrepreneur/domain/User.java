package com.dhp.entrepreneur.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * User class is an abstract superclass.
 * A "single table" Hibernate strategy has been chosen to enhance performance.
 */
@Entity
@Table(name="USER")
public abstract class User {
	
	protected long id;
	protected String name;
	protected String surname;
	protected String email;
	protected List<Project> projects;
	protected Company company;  // each user belongs to 1 company.
	
	/** Default constructor for Hibernate */
	protected User() {
		super();
	}

	/**
	 * Constructor overloading with all the necessary parameters. 
	 * @param name - name of user 
	 * @param surname - surname of user 
	 * @param email - email of user
	 * @param useraccount - userAccount of the user 
	 * @param company - company of the user 
	 **/
	protected User(String  name, String surname, String email, Company company){
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.company = company;
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
	
	@Column(name="SURNAME") 
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name="EMAIL") 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany(cascade={CascadeType.ALL}, targetEntity=Project.class)
	@JoinTable(name="USER_PROJECT")
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@ManyToOne(targetEntity=Company.class, cascade=CascadeType.ALL)
	@JoinColumn(name="COMPANY_ID")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
