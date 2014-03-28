package com.dhp.entrepreneur.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dhp.entrepreneur.dao.ProjectDao;
import com.dhp.entrepreneur.domain.Project;

@Component
@Transactional
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Project project) {
		this.sessionFactory.getCurrentSession().save(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllWithNoPoints(long companyID, String department) {	
		return this.sessionFactory.getCurrentSession()
				.createCriteria(Project.class).add(Restrictions.le("point", 0))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllWithPoints(long companyID, String department) {
		return this.sessionFactory.getCurrentSession()
				.createCriteria(Project.class).add(Restrictions.gt("point", 0))
				.list();
	}

	@Override
	public void update(Project project) {
		this.sessionFactory.getCurrentSession().update(project);
	}

	@Override
	public Project get(long projectID) {
		return (Project) this.sessionFactory.getCurrentSession().get(Project.class, projectID);
	}

	@Override
	public void delete(Project project) {
		this.sessionFactory.getCurrentSession().delete(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllOwnProjects(long companyID, String department) {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Project WHERE PROJECT_TYPE = 'OWN_PROJECT'").list();	
		}
}
