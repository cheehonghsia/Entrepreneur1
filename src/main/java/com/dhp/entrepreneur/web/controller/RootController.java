package com.dhp.entrepreneur.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhp.entrepreneur.domain.Role;

@Controller
public class RootController {

	@RequestMapping(value = { "/", "index.html" }, method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }
	
	@RequestMapping(value = { "login.html" }, method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "mentor/*")
	public String getMentorHome() {
		return "mentor/helloMentor";
	}
	
	@RequestMapping(value = "participant/*")
	public String getParticipantHome() {
		return "participant/helloParticipant";
	}
	
	public String getHomeRedirectLocation(Role role) {
        String redirectLocation = "/";
        
        switch(role) {
        	case MENTOR: redirectLocation = "/mentor/helloMentor.html"; break;
        	case PARTICIPANT: redirectLocation = "/participant/helloParticipant.html"; break;
        }

        return redirectLocation;
    }
}
