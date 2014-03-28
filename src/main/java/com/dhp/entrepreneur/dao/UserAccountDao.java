package com.dhp.entrepreneur.dao;

import com.dhp.entrepreneur.domain.UserAccount;

/**
 * @author Chee-HongH
 * User account dao interface
 */
public interface UserAccountDao {

	/**
	 * Retrieve an unique user account object based on the following parameters:
	 * @param username
	 * @param password
	 * @return an unique user account object.
	 */
	public UserAccount get(String username, String password);
	
	/**
	 * Retrieve an unique user account object based on the following parameters:
	 * @param username
	 * @return an unique user account object.
	 */
	public UserAccount get(String username);

	/**
	 * Save user account.
	 * @param user
	 */
	public void save(UserAccount userAccount);

}
