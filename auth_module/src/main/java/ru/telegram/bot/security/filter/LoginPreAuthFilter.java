package ru.telegram.bot.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.telegram.bot.security.filter.api.AbstractAuthenticatedProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Profile("local")
@Component
@Slf4j
public class LoginPreAuthFilter extends AbstractAuthenticatedProcessingFilter {

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain) {
        log.info("{}", request);
    }
}
