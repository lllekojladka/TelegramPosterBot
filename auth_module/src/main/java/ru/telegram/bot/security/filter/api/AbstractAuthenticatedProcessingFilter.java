package ru.telegram.bot.security.filter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import ru.telegram.bot.security.manager.api.AbstractAuthenticatedManager;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    private static final RuntimeException INCORRECT_USAGE = new UnsupportedOperationException("Incorrect usage");

    @Autowired
    private AbstractAuthenticatedManager authenticationManager;


    @PostConstruct
    public void init() {
        super.setAuthenticationManager(authenticationManager);
    }


    @Override
    protected Object getPreAuthenticatedPrincipal(final HttpServletRequest httpServletRequest) {
        throw INCORRECT_USAGE;
    }


    @Override
    protected Object getPreAuthenticatedCredentials(final HttpServletRequest httpServletRequest) {
        throw INCORRECT_USAGE;
    }
}
