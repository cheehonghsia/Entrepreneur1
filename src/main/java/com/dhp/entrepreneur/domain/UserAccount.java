package com.dhp.entrepreneur.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>@author Chee-Hong Hsia </b><br>
 * This class represents the useraccount of an user.  
 */
@Entity
@Table(name="USERACCOUNT")
public class UserAccount {
	
	private long id;
	private String username;
	private String password;
    private Role role;
	private User user;
	
	/** Default constructor for Hibernate */
	@SuppressWarnings("unused")
	private UserAccount() {
		super();
	}
	
	/**
	 * Constructor overloading with all the necessary parameters. 
	 * @param username
	 * @param password
	 * @param user
	 * @param role
	 */
	public UserAccount(String username, String password, User user, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.user = user;
		this.role = role;
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
	
	@Column(name="USERNAME", nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID") 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
