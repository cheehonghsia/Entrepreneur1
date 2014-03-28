package com.dhp.entrepreneur.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.dhp.entrepreneur.domain.Competition;
import com.dhp.entrepreneur.domain.Status;
import com.dhp.entrepreneur.domain.TimeDrivenCompetition;
import com.dhp.entrepreneur.service.CompetitionService;

@Controller
public class CompetitionController {
	
	@Autowired private CompetitionService competitionService;
	
	@RequestMapping(value="/Competitions", method = RequestMethod.GET)
	public String initCompetitionForm(ModelMap model) {
		
		// Temporarily disabled due to dummy code
		//this.competitionService.getAll(companyID, department);
		Competition timeCompetition1 = new TimeDrivenCompetition("Competition A", new Date(), new Date(), null, null, Status.NOT_ACTIVE);
		Competition timeCompetition2 = new TimeDrivenCompetition("Competition B", new Date(), new Date(), null, null, Status.NOT_ACTIVE);
		List<Competition> competitions = new ArrayList<Competition>();
		competitions.add(timeCompetition1);
		competitions.add(timeCompetition2);
		model.addAttribute("competitions", competitions);
		
		return "Competitions";
	}
	
	@RequestMapping(value="/CreateCompetition", method = RequestMethod.GET)
	public String initCreateCompetitionForm(ModelMap model) {
		model.addAttribute("timeDrivenCompetition", new TimeDrivenCompetition());
		return "CreateCompetition";
	}

	@RequestMapping(value="/CreateCompetition", method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("timeDrivenCompetition") TimeDrivenCompetition timeDrivenCompetition,
			BindingResult result, SessionStatus status) {
		this.competitionService.createCompetition(timeDrivenCompetition);
		return "redirect:Competitions";
	}
}
