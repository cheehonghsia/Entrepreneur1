package com.dhp.entrepreneur.base;

import com.dhp.entrepreneur.domain.Company;
import com.dhp.entrepreneur.domain.Mentor;
import com.dhp.entrepreneur.domain.Participant;
import com.dhp.entrepreneur.domain.Role;
import com.dhp.entrepreneur.domain.User;
import com.dhp.entrepreneur.domain.UserAccount;

public class TestSetup extends InMemorySetup{
	
	/**
	 * This method create and returns a Mentor user account object.
	 * @return mentor user account object
	 */
	public UserAccount createMentorUserAccount(){
		// Administrator creates initial mentor user.
		Company company = new Company("Bar", "KVK123456789", "J2EE");
		User mentor = new Mentor("Jane", "Doe", "Jane.Doe@Foo.com", company);
		UserAccount localuserAccount = new UserAccount("JaneDoe", "123456", mentor, Role.MENTOR);
		super.userAccountDao.save(localuserAccount);
		return super.userAccountDao.get("JaneDoe", "123456");
	}
	/**
	 * This method creates and returns a Participant user account object.
	 * @param company
	 * @return participant user account object.
	 */
	public UserAccount createParticipantUserAccount(Company company){
		User user = new Participant("John", "Doe", "John.Doe@Foo.com", company);
		UserAccount participantUserAccount = new UserAccount("JohnDoe", "123456", user, Role.PARTICIPANT);
		super.userAccountDao.save(participantUserAccount);
		return super.userAccountDao.get("JohnDoe", "123456");
	}
}
