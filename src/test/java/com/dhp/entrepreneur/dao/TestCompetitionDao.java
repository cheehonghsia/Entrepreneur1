package com.dhp.entrepreneur.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhp.entrepreneur.base.TestSetup;
import com.dhp.entrepreneur.domain.Company;
import com.dhp.entrepreneur.domain.Competition;
import com.dhp.entrepreneur.domain.PointDrivenCompetition;
import com.dhp.entrepreneur.domain.PredefinedProject;
import com.dhp.entrepreneur.domain.Project;
import com.dhp.entrepreneur.domain.Status;
import com.dhp.entrepreneur.domain.TimeDrivenCompetition;
import com.dhp.entrepreneur.domain.UserAccount;

/**
 * @author Chee-Hong Hsia
 * Testing the CompetitionDao class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCompetitionDao extends TestSetup {
	
	@Test
	public void saveAndGetAllCompetition(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in and creates a Participant user account
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a TestDrivenCompetition.
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), null, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
		Competition pointDrivenCompetition = new PointDrivenCompetition("TimeDrivenCompetition", 50, null, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(pointDrivenCompetition);
		
		// test
		List< Competition> competitions = super.competitionDao.getAll(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertNotNull(competitions);
		Assert.assertEquals(2, competitions.size());
	}

	@Test
	public void updateCompetition(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a TestDrivenCompetition.
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), null, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
		
		// Mentor change the name of the Competition.
		timeDrivenCompetition.setName("newValue");
		super.competitionDao.update(timeDrivenCompetition);
		
		// test
		List< Competition> competitions = super.competitionDao.getAll(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertNotNull(competitions);
		Assert.assertEquals("newValue", competitions.get(0).getName());
	}
	
	@Test
	public void deleteCompetition(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a TestDrivenCompetition.
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), null, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
		
		// test
		List< Competition> competitions = super.competitionDao.getAll(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertNotNull(competitions);
		Assert.assertEquals(1, competitions.size());
		
		super.competitionDao.delete(timeDrivenCompetition);
		
		// test
		List< Competition> competitions2 = super.competitionDao.getAll(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertNotNull(competitions2);
		Assert.assertEquals(0, competitions2.size());
	}
	
	@Test
	public void deleteCompetitionWithProjects(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates 2 predefined projects.
		Project projectA = new PredefinedProject("PredefinedProject1", "description1", 10, retrievedMentorCompany);
		this.projectDao.create(projectA);
		Project projectB = new PredefinedProject("PredefinedProject2", "description2", 20, retrievedMentorCompany);
		this.projectDao.create(projectB);
		List<Project> projects = new ArrayList<Project>();
		projects.add(projectA);
		projects.add(projectB);
		
		// Mentor creates a TestDrivenCompetition.
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), projects, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
		
		// test
		List< Competition> competitions = super.competitionDao.getAll(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertNotNull(competitions);
		Assert.assertEquals(1, competitions.size());
		
		super.competitionDao.delete(timeDrivenCompetition);
		
		// test if Competition has been deleted.
		List< Competition> competitions2 = super.competitionDao.getAll(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertNotNull(competitions2);
		Assert.assertEquals(0, competitions2.size());
		
		// test if the Projects still remains.
		List<Project> retrievedProjects = super.projectDao.getAllWithPoints(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Assert.assertEquals(2, retrievedProjects.size());
	}
	
	@Test
	public void doesNotHaveProjects(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a TestDrivenCompetition.
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), null, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
	
		boolean hasProject = super.competitionDao.hasProjects(timeDrivenCompetition.getId());
		Assert.assertFalse(hasProject); // this competition contains no projects so it should return false. 
	}
	
	@Test
	public void hasProjects(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a project and add it to TestDrivenCompetition.
		Project project = new PredefinedProject("predefinedproject", "description", retrievedMentorCompany);
		super.projectDao.create(project);
		List<Project> projects = new ArrayList<Project>();
		projects.add(project);
		
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), projects, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
	
		boolean hasProject = super.competitionDao.hasProjects(timeDrivenCompetition.getId());
		Assert.assertTrue(hasProject); // this competition contains 1 project so it should return true. 
	}
	
	@Test
	public void addProjectsToCompetition(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a project and add it to TestDrivenCompetition.
		Project project1 = new PredefinedProject("predefinedproject", "description", retrievedMentorCompany);
		super.projectDao.create(project1);
		Project project2 = new PredefinedProject("predefinedproject", "description", retrievedMentorCompany);
		super.projectDao.create(project2);
		
		List<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		
		// Mentor creates a Competition and adds 2 later.
		Project defaultProject = new PredefinedProject("default", "default", retrievedMentorCompany);
		super.projectDao.create(defaultProject);
		List<Project> defaultProjects = new ArrayList<Project>();
		defaultProjects.add(defaultProject);
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), defaultProjects, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
		
		// test if Competition contains the default project.
		Assert.assertEquals(1, timeDrivenCompetition.getProjects().size());
		
		// test adding 2 extra projects by using the addProject method.
		super.competitionDao.addProject(timeDrivenCompetition, projects);
		Assert.assertEquals(3, timeDrivenCompetition.getProjects().size());
	}
	
	@Test
	public void removeProjectsToCompetition(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in.
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a project and add it to TestDrivenCompetition.
		Project project1 = new PredefinedProject("predefinedproject", "description", retrievedMentorCompany);
		super.projectDao.create(project1);
		Project project2 = new PredefinedProject("predefinedproject", "description", retrievedMentorCompany);
		super.projectDao.create(project2);
		
		List<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		
		// Mentor creates a Competition and adds 2 later.
		Project defaultProject = new PredefinedProject("default", "default", retrievedMentorCompany);
		super.projectDao.create(defaultProject);
		List<Project> defaultProjects = new ArrayList<Project>();
		defaultProjects.add(defaultProject);
		Competition timeDrivenCompetition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), defaultProjects, retrievedMentorCompany, Status.ACTIVE);
		super.competitionDao.create(timeDrivenCompetition);
		
		// test if Competition contains the default project.
		Assert.assertEquals(1, timeDrivenCompetition.getProjects().size());
		
		// test adding 2 extra projects by using the addProject method.
		super.competitionDao.addProject(timeDrivenCompetition, projects);
		Assert.assertEquals(3, timeDrivenCompetition.getProjects().size());
		
		super.competitionDao.removeProject(timeDrivenCompetition, projects);
		Assert.assertEquals(1, timeDrivenCompetition.getProjects().size());
		
		super.competitionDao.removeProject(timeDrivenCompetition, defaultProjects);
		Assert.assertEquals(0, timeDrivenCompetition.getProjects().size());
	}
}