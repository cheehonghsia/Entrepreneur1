package com.dhp.entrepreneur.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <b>@author Chee-Hong Hsia </b><br> 
 * The company which the user is working for.
 */
@Entity
@Table(name="COMPANY")
public class Company {
	
	private long id;
	private String kvkNr;
	private String name;
	// from the company class you want to be able to retrieve all users within a certain company
	private List<User> users;
	private String department;

	/** Default constructor for Hibernate */	
	@SuppressWarnings("unused")
	private Company() {
		super();
	}
	
	/**
	 * Constructor overloading with all the necessary parameters. 
	 * @param companyName
	 * @param kvkNr
	 * @param department
	 **/
	public Company(String companyName, String kvkNr, String department) {
		super();
		this.name = companyName;
		this.kvkNr = kvkNr;
		this.department = department;
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
	
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL, targetEntity=User.class)  
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Column(name="KVKNR")
	public String getKvkNr() {
		return kvkNr;
	}

	public void setKvkNr(String kvkNr) {
		this.kvkNr = kvkNr;
	}

	@Column(name="DEPARTMENT")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
