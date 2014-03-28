package com.dhp.entrepreneur.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dhp.entrepreneur.dao.CompetitionDao;
import com.dhp.entrepreneur.domain.Competition;
import com.dhp.entrepreneur.domain.Project;

@Component
@Transactional
public class CompetitionDaoImpl implements CompetitionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Competition competition) {
		this.sessionFactory.getCurrentSession().save(competition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competition> getAll(long companyID, String department) {
		return this.sessionFactory.getCurrentSession()
				.createCriteria(Competition.class)
				.createAlias("company", "comp")
				.add(Restrictions.eq("comp.id", companyID))
				.add(Restrictions.eq("comp.department", department))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public void update(Competition competition) {
		this.sessionFactory.getCurrentSession().update(competition);
	}

	@Override
	public void delete(Competition competition) {
		this.sessionFactory.getCurrentSession().delete(competition);
	}

	@Override
	public boolean hasProjects(long competitionID) {
		int size = this.sessionFactory.getCurrentSession()
				.createCriteria(Competition.class)
				.add(Restrictions.eq("id", competitionID))
				.add(Restrictions.isNotEmpty("projects")).list().size();
		return (size > 0) ? true : false;
	}

	@Override
	public void addProject(Competition competition, List<Project> projects) {
		List<Project> oldValueProjects = competition.getProjects();
		List<Project> newValueProjects = new ArrayList<Project>();
		newValueProjects.addAll(oldValueProjects);
		newValueProjects.addAll(projects);
		competition.setProjects(newValueProjects);
		this.update(competition);
	}

	@Override
	public void removeProject(Competition competition, List<Project> removedProjects) {
		List<Project> currentProjects = competition.getProjects();
		currentProjects.removeAll(removedProjects);
		competition.setProjects(currentProjects);
		this.update(competition);
	}
}
