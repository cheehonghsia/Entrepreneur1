package com.dhp.entrepreneur.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * This is the Project class. Each competition can have 1 or many projects and each project can be assigned to 
 * different Competitions. The Project class is also linked to the User class so that user data can be retrieved.
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PROJECT_TYPE", discriminatorType=DiscriminatorType.STRING)
@Table(name="PROJECT")
public abstract class Project {
	
	private long id;
	protected String name;
	protected String description;
	protected int point;
	protected List<? extends User> users;
	protected boolean isActive; // indicates if the project is still active or finished (inactive)
	protected Company company;
	
	/** Default constructor for Hibernate */
	protected Project() {
		super();
	}
	
	/**
	 * Constructor with the following parameters:
	 * @param name - project name
	 * @param description - project description
	 * @param isActive - true if the project is still active, no if it is not-active.
	 */
	protected Project(String name, String description, int point, boolean isActive, Company company){
		super();
		this.name = name;
		this.description = description;
		this.point = point;
		this.isActive = isActive;
		this.company = company;
	}	
	
	/**
	 * Method that checks whether this project has points.
	 * @return true if it has points, otherwise false.
	 */
	public boolean hasPoint(){
		return (this.point > 0) ? true : false;
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
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="POINT")
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@ManyToMany(mappedBy="projects", targetEntity=User.class, cascade={CascadeType.PERSIST})
	public List<? extends User> getUsers() {
		return users;
	}
	public void setUsers(List<? extends User> users) {
		this.users = users;
	}
	
	@Column(name="IS_ACTIVE")
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@OneToOne(cascade=CascadeType.PERSIST)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
