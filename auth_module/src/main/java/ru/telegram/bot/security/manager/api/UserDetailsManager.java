package ru.telegram.bot.security.manager.api;

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;


public interface UserDetailsManager extends AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

}
