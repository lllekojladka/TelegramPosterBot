package ru.telegram.bot.security.manager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import javax.annotation.PostConstruct;

public class AbstractAuthenticatedManager extends PreAuthenticatedAuthenticationProvider implements AuthenticationManager {

    @Autowired
    private UserDetailsManager userDetailsManager;


    @PostConstruct
    public void init() {
        this.setPreAuthenticatedUserDetailsService(userDetailsManager);
    }


    @Override
    public Authentication authenticate(Authentication authentication) {
        return authentication;
    }
}
