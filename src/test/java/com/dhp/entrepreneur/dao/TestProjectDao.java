package com.dhp.entrepreneur.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhp.entrepreneur.base.TestSetup;
import com.dhp.entrepreneur.domain.Company;
import com.dhp.entrepreneur.domain.OwnProject;
import com.dhp.entrepreneur.domain.PredefinedProject;
import com.dhp.entrepreneur.domain.Project;
import com.dhp.entrepreneur.domain.UserAccount;

/**
 * @author Chee-Hong Hsia
 * Testing the ProjectDao class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProjectDao extends TestSetup {
	
	@Test
	public void getAllOwnProjects() {
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		
		// Mentor log in and creates a Participant user account
		Company retrievedMentorCompany = mentorUserAccount.getUser().getCompany();
		UserAccount participantUserAccount = super.createParticipantUserAccount(retrievedMentorCompany);
		
		// Participant log in and creates an OwnProject
		Company retrievedParticipantCompany = participantUserAccount.getUser().getCompany();
		Project project = new OwnProject("OwnProject", "description1", retrievedParticipantCompany);
		super.projectDao.create(project);
		
		// Mentor logs in and retrieves all OwnProjects
		List<Project> ownProjects = super.projectDao.getAllOwnProjects(retrievedMentorCompany.getId(), retrievedMentorCompany.getDepartment());
		Project retrievedProject = ownProjects.get(0);
		Assert.assertNotNull(ownProjects);
		Assert.assertEquals(1, ownProjects.size()); 
		Assert.assertEquals(project.getName(), retrievedProject.getName()); 
		Assert.assertEquals(project.getDescription(), retrievedProject.getDescription()); 
		Assert.assertEquals(false, retrievedProject.isActive()); 
	}
	
	@Test
	public void getAllWithNoPoints(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		Company company = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates 5 predefined projects
		Project project1 = new PredefinedProject("PredefinedProject1", "description1", 10, company);
		super.projectDao.create(project1);
		Project project2 = new PredefinedProject("PredefinedProject2", "description2", 20, company);
		super.projectDao.create(project2);
		Project projectWithNoPoint1 = new PredefinedProject("PredefinedProject3", "description3", company); // 3 projects with no points defined.
		super.projectDao.create(projectWithNoPoint1);
		Project projectWithNoPoint2 = new PredefinedProject("PredefinedProject4", "description4", company);
		super.projectDao.create(projectWithNoPoint2);
		Project projectWithNoPoint3 = new PredefinedProject("PredefinedProject5", "description5", company);
		super.projectDao.create(projectWithNoPoint3);
		
		List<Project> retrievedProjectsWithNoPoints = super.projectDao.getAllWithNoPoints(company.getId(), company.getDepartment());
		Assert.assertNotNull(retrievedProjectsWithNoPoints);
		Assert.assertEquals(3, retrievedProjectsWithNoPoints.size()); 
	}
	
	@Test
	public void getAllWithPoints(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		Company company = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates 5 predefined projects
		Project project1 = new PredefinedProject("PredefinedProject1", "description1", 10, company);
		super.projectDao.create(project1);
		Project project2 = new PredefinedProject("PredefinedProject2", "description2", 20, company);
		super.projectDao.create(project2);
		Project projectWithNoPoint1 = new PredefinedProject("PredefinedProject3", "description3", company); // 3 projects with no points defined.
		super.projectDao.create(projectWithNoPoint1);
		Project projectWithNoPoint2 = new PredefinedProject("PredefinedProject4", "description4", company);
		super.projectDao.create(projectWithNoPoint2);
		Project projectWithNoPoint3 = new PredefinedProject("PredefinedProject5", "description5", company);
		super.projectDao.create(projectWithNoPoint3);
		List<Project> retrievedProjectsPoints = super.projectDao.getAllWithPoints(company.getId(), company.getDepartment());
		Assert.assertNotNull(retrievedProjectsPoints);
		Assert.assertEquals(2, retrievedProjectsPoints.size()); 
	}
	
	@Test
	public void getUniqueProject(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		Company company = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates 5 predefined projects
		Project project1 = new PredefinedProject("PredefinedProject1", "description1", 10, company);
		super.projectDao.create(project1);
		Project project2 = new PredefinedProject("PredefinedProject2", "description2", 20, company);
		super.projectDao.create(project2);
		Project projectWithNoPoint1 = new PredefinedProject("PredefinedProject3", "description3", company); // 3 projects with no points defined.
		super.projectDao.create(projectWithNoPoint1);
		Project projectWithNoPoint2 = new PredefinedProject("PredefinedProject4", "description4", company);
		super.projectDao.create(projectWithNoPoint2);
		Project projectWithNoPoint3 = new PredefinedProject("PredefinedProject5", "description5", company);
		super.projectDao.create(projectWithNoPoint3);
		List<Project> retrievedProjects = super.projectDao.getAllWithPoints(company.getId(), company.getDepartment());
		
		// Mentor gets the details of a project based on the projectID
		long projectID = retrievedProjects.get(0).getId();
		Project project = super.projectDao.get(projectID);
		
		Assert.assertNotNull(project);
		Assert.assertEquals(project1.getName(), project.getName()); 
		Assert.assertEquals(project1.getDescription(), project.getDescription()); 
		Assert.assertEquals(project1.isActive(), project.isActive()); 
		Assert.assertEquals(project1.getCompany().getName(), project.getCompany().getName()); 
		Assert.assertEquals(project1.getCompany().getKvkNr(), project.getCompany().getKvkNr()); 
	}
	
	@Test
	public void modifyProject(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		Company company = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a predefined projects
		Project project = new PredefinedProject("PredefinedProject1", "description1", 10, company);
		super.projectDao.create(project);
		List<Project> retrievedProjects = super.projectDao.getAllWithPoints(company.getId(), company.getDepartment());
		
		// Mentor gets the details of a project based on the projectID
		long projectID = retrievedProjects.get(0).getId();
		Project retrievedProject = super.projectDao.get(projectID);
		
		// Mentor changes the project information
		retrievedProject.setDescription("description changed by mentor");
		retrievedProject.setName("project name changed by mentor");
		retrievedProject.setPoint(5);
		
		super.projectDao.update(retrievedProject);
		
		Project retrievedProject2 = super.projectDao.get(projectID);
		Assert.assertNotNull(retrievedProject2);
		Assert.assertEquals(retrievedProject.getName(), retrievedProject2.getName()); 
		Assert.assertEquals(retrievedProject.getDescription(), retrievedProject2.getDescription()); 
		Assert.assertEquals(retrievedProject.isActive(), retrievedProject2.isActive()); 
		Assert.assertEquals(retrievedProject.getCompany().getName(), retrievedProject2.getCompany().getName()); 
		Assert.assertEquals(retrievedProject.getCompany().getKvkNr(), retrievedProject2.getCompany().getKvkNr());
	}
	
	@Test
	public void deleteProject(){
		// Administrator creates a mentor user account.
		UserAccount mentorUserAccount = super.createMentorUserAccount();
		Company company = mentorUserAccount.getUser().getCompany();
		
		// Mentor creates a project.
		Project project = new PredefinedProject("PredefinedProject1", "description1", 10, company);
		super.projectDao.create(project);
		
		List<Project> retrievedProjects = super.projectDao.getAllWithPoints(company.getId(), company.getDepartment());
		Assert.assertEquals(1, retrievedProjects.size());
		
		super.projectDao.delete(retrievedProjects.get(0));
		
		List<Project> retrievedProjects2 = super.projectDao.getAllWithPoints(company.getId(), company.getDepartment());
		Assert.assertEquals(0, retrievedProjects2.size()); // project has been deleted so should be 0
	}
	
//	@Test
//	public void deleteProjectInCompetition(){
//		// Administrator creates a mentor user account.
//		UserAccount mentorUserAccount = super.createMentorUserAccount();
//		Company company = mentorUserAccount.getUser().getCompany();
//		
//		// Mentor creates a predefined project
//		Project project = new PredefinedProject("PredefinedProject1", "description1", 10, company);
//		super.projectDao.create(project);
//		
//		List<Project> retrievedProjects = super.projectDao.getAllWithPoints(company.getId(), company.getDepartment());
//		Assert.assertEquals(1, retrievedProjects.size());
//		
//		Competition competition = new TimeDrivenCompetition("TimeDrivenCompetition", new Date(), new Date(), retrievedProjects, company, true);
//		super.competitionDao.create(competition);
//		super.projectDao.delete(project);
//		
//		List<Project> retrievedProjects2 = super.projectDao.getAll(company.getId(), company.getDepartment());
//		Assert.assertEquals(0, retrievedProjects2.size()); // project has been deleted so should be 0
//	}
}
