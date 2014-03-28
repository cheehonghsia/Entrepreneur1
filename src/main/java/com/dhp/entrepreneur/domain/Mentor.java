package com.dhp.entrepreneur.domain;

import javax.persistence.Entity;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * Mentor is the subclass of the abstract User superclass.
 * A mentor is an administrator and mentor of a participant. Each project has 1 mentor and each mentor can 
 * have 1 or many participants to guide.  
 */
@Entity
public class Mentor extends User {

	/** Default constructor for Hibernate */
	@SuppressWarnings("unused")
	private Mentor() {
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
	public Mentor(String name, String surname, String email, Company company){
		super(name, surname, email, company);
	}
}
