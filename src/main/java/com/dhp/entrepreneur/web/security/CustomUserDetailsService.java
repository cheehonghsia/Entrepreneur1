package com.dhp.entrepreneur.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.dhp.entrepreneur.dao.UserAccountDao;
import com.dhp.entrepreneur.domain.UserAccount;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserAccountDao userAccountDao;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException, DataAccessException {
        final UserAccount userAccount = userAccountDao.get(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("Could not find user with username [" + username + "]");
        }
        return new CustomUserDetails(userAccount);
    }

}


