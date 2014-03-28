package com.dhp.entrepreneur.web.security;

import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dhp.entrepreneur.domain.Role;
import com.dhp.entrepreneur.domain.UserAccount;

public class CustomUserDetails implements UserDetails {

	    private final UserAccount userAccount;

	    public CustomUserDetails(final UserAccount userAccount) {
	        Validate.notNull(userAccount, "User account cannot be null");
	        Validate.notNull(userAccount.getRole(), "Role cannot be null");

	        this.userAccount = userAccount;
	    }

	    public UserAccount getUserAccount() {
	        return userAccount;
	    }
	    
	    public Role getRole() {
	    	return userAccount.getRole();
	    }


	    @Override
	    public Collection<GrantedAuthority> getAuthorities() {

	        final Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	        
            authorities.add(new GrantedAuthority() {

                @Override
                public String getAuthority() {
                    return "ROLE_" + userAccount.getRole().name();
                }
            });
	        
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return userAccount.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return userAccount.getUsername();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public String toString() {
	        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	    }

	}


