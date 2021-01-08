package ru.telegram.bot.security.filter.api;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import ru.telegram.bot.exception.TokenException;
import ru.telegram.bot.security.manager.api.AbstractAuthenticatedManager;
import ru.telegram.bot.security.manager.api.TokenManager;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
public abstract class AbstractAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    private static final RuntimeException INCORRECT_USAGE = new UnsupportedOperationException("Incorrect usage");

    @Autowired
    protected AbstractAuthenticatedManager authenticationManager;
    @Autowired
    protected TokenManager tokenManager;


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


    @SneakyThrows
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            doFilter(httpRequest, httpResponse, chain);
        } catch (Exception e) {
            log.error("Error authenticate", e);
            unsuccessfulAuthentication(httpRequest, httpResponse, new BadCredentialsException("Incorrect authenticate"));
        }
        chain.doFilter(request, response);
    }


    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain);


    protected String getTokenFromRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(tokenManager::validate)
                .orElseThrow(() -> new TokenException("Token is not valid"))
                ;
    }


    @SneakyThrows
    protected void successfulAuthenticate(HttpServletRequest request, HttpServletResponse response, UserDetails userDetails) {
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(userDetails.getUsername(), "N/A");

        successfulAuthentication(request, response, token);
    }
}
