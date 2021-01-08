package ru.telegram.bot.security.manager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import ru.telegram.bot.model.User;

import javax.annotation.PostConstruct;
import java.util.Optional;

public abstract class AbstractAuthenticatedManager extends PreAuthenticatedAuthenticationProvider implements AuthenticationManager {

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


    public abstract Optional<User> authenticateByLogin(User user);


    public abstract Optional<User> authenticateByPassword(User user);
}
