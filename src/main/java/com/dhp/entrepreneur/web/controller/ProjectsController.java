package com.dhp.entrepreneur.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.dhp.entrepreneur.domain.PredefinedProject;
import com.dhp.entrepreneur.service.ProjectService;

@Controller
public class ProjectsController {
	
	@Autowired private ProjectService projectService;
	
	@RequestMapping(value="/Projects", method = RequestMethod.GET)
	public String initProjectForm(ModelMap model) {
		
		// Temporarily disabled due to dummy code
		//this.projectService.getAll(companyID, department);
//		Competition timeCompetition = new TimeDrivenCompetition("ACME Competition", new Date(), new Date(), null, null, false);
//		List<Competition> competitions = new ArrayList<Competition>();
//		competitions.add(timeCompetition);
//		model.addAttribute("competitions", competitions);
//		
		return "Projects";
	}
	
	@RequestMapping(value="/CreateProject", method = RequestMethod.GET)
	public String initCreateCompetitionForm(ModelMap model) {
		model.addAttribute("predefinedProject", new PredefinedProject());
		return "CreateProject";
	}
	
	@RequestMapping(value="/CreateProject", method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("predefinedProject") PredefinedProject predefinedProject,
			BindingResult result, SessionStatus status) {
		
		this.projectService.create(predefinedProject);
		
		return "Projects";
	}

}
