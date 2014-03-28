package com.dhp.entrepreneur.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dhp.entrepreneur.domain.Role;
import com.dhp.entrepreneur.domain.UserAccount;
import com.dhp.entrepreneur.web.controller.RootController;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

	//    @Autowired
	//    private UserAccountUpdateService userAccountUpdateService;
	
	//    @Autowired
	//    private LocaleResolver localeResolver;

    @Autowired
    private RootController rootController;
    
    @Transactional
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        final CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        final UserAccount userAccount = customUserDetails.getUserAccount();       
        final Role role = userAccount.getRole(); 
        
		//        Locale locale = userAccount.getLocale();
		//        if (locale == null) {
		//            locale = localeResolver.resolveLocale(request);
		//            userAccountUpdateService.changeLocale(userAccountId, locale);
		//        }
		//		localeResolver.setLocale(request, response, locale);

        String redirectUri = rootController.getHomeRedirectLocation(role);
        if (!StringUtils.startsWith(redirectUri, "/")) {
            redirectUri = "/" + redirectUri;
        }
        redirectUri = request.getContextPath() + redirectUri;
        logger.debug("User has the role {}, redirect to: {}", role, redirectUri);
        response.sendRedirect(redirectUri);
    }

}
