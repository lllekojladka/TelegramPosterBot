package ru.telegram.bot.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.telegram.bot.exception.TokenException;
import ru.telegram.bot.model.User;
import ru.telegram.bot.security.filter.api.AbstractAuthenticatedProcessingFilter;
import ru.telegram.bot.security.manager.api.AbstractAuthenticatedManager;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Profile("local")
@Component
@Slf4j
@RequiredArgsConstructor
public class LoginPreAuthFilter extends AbstractAuthenticatedProcessingFilter {

    @Override
    public void doFilter(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final FilterChain chain) {
        String tokenFromRequest = getTokenFromRequest(request);

        User user = tokenManager.getUser(tokenFromRequest);

        authenticationManager.authenticateByLogin(user)
                .orElseThrow(() -> new TokenException("User not found"))
        ;

        successfulAuthenticate(request, response, user);
    }
}
