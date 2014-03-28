package com.dhp.entrepreneur.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhp.entrepreneur.base.InMemorySetup;
import com.dhp.entrepreneur.domain.Company;
import com.dhp.entrepreneur.domain.Mentor;
import com.dhp.entrepreneur.domain.Participant;
import com.dhp.entrepreneur.domain.Role;
import com.dhp.entrepreneur.domain.User;
import com.dhp.entrepreneur.domain.UserAccount;

/**
 * @author Chee-Hong Hsia
 * Testing the UseraccountDao class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserAccountDao extends InMemorySetup {

	@Test
	public void adminCreateMentorUseraccount(){
		// Administrator creates a user, company, user account and saves it.
		Company company = new Company("Bar", "KVK123456789", "J2EE");
		User mentor = new Mentor("Jane", "Doe", "Jane.Doe@Foo.com", company);
		UserAccount localuserAccount = new UserAccount("JaneDoe", "123456", mentor, Role.MENTOR);
		super.userAccountDao.save(localuserAccount);
		UserAccount retrievedUserAccount = super.userAccountDao.get("JaneDoe", "123456");
		Assert.assertEquals(localuserAccount.getUsername(), retrievedUserAccount.getUsername()); // check if user account has been saved.
		Assert.assertEquals(localuserAccount.getPassword(), retrievedUserAccount.getPassword());
		
		// Mentor log in and his credentials are retrieved. After this line, all operations are based on this retrieval
		User retrievedUser = retrievedUserAccount.getUser();
		Company retrievedCompany = retrievedUserAccount.getUser().getCompany();
		Assert.assertNotNull(retrievedUser); // check if retrieved object is not null
		Assert.assertNotNull(retrievedCompany);
	}
	
	@Test
	public void mentorCreateParticipantUseraccount(){
		// Administrator creates a user, company, user account and saves it.
		Company company = new Company("Bar", "KVK123456789", "J2EE");
		User mentor = new Mentor("Jane", "Doe", "Jane.Doe@Foo.com", company);
		UserAccount localuserAccount = new UserAccount("JaneDoe", "123456", mentor, Role.MENTOR);
		super.userAccountDao.save(localuserAccount);
		UserAccount retrievedUserAccount = super.userAccountDao.get("JaneDoe", "123456");
		Assert.assertEquals(localuserAccount.getUsername(), retrievedUserAccount.getUsername()); // check if user account has been saved.
		Assert.assertEquals(localuserAccount.getPassword(), retrievedUserAccount.getPassword());
		
		Company retrievedCompany = retrievedUserAccount.getUser().getCompany();
		Assert.assertNotNull(retrievedCompany);
		
		// Mentor creates a participant
		User participant = new Participant("John", "Doe", "John.Doe@Foo.com", retrievedCompany);
		UserAccount userAccountParticipant = new UserAccount("JohnDoe", "111111", participant, Role.MENTOR);
		super.userAccountDao.save(userAccountParticipant);
		UserAccount retrievedUseraccount = super.userAccountDao.get("JohnDoe", "111111");
		Assert.assertEquals(participant.getName(), retrievedUseraccount.getUser().getName());
		Assert.assertEquals(participant.getSurname(), retrievedUseraccount.getUser().getSurname());
		Assert.assertEquals(participant.getEmail(), retrievedUseraccount.getUser().getEmail());
		Assert.assertEquals(participant.getCompany().getName(), retrievedUseraccount.getUser().getCompany().getName());
		Assert.assertEquals(participant.getCompany().getDepartment(), retrievedUseraccount.getUser().getCompany().getDepartment());
		Assert.assertEquals(participant.getCompany().getKvkNr(), retrievedUseraccount.getUser().getCompany().getKvkNr());
	}

}
