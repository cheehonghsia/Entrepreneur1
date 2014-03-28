package com.dhp.entrepreneur.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhp.entrepreneur.dao.ProjectDao;
import com.dhp.entrepreneur.domain.PredefinedProject;
import com.dhp.entrepreneur.domain.Project;
import com.dhp.entrepreneur.service.ProjectService;

@Component
public class ProjectServiceImpl implements ProjectService {

	@Autowired private ProjectDao projectDao;

	@Override
	public void save(Project project) {
		if (project != null) {
			this.projectDao.create(project);
		}
	}

	@Override
	public void create(PredefinedProject project) {
		this.projectDao.create(project);
	}
}
