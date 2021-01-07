package ru.telegram.bot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import ru.telegram.bot.security.filter.api.AbstractAuthenticatedProcessingFilter;

import static ru.telegram.bot.util.AuthURLConstants.TOKEN;

@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final AuthenticationEntryPoint authEntryPoint = new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);

    private final AbstractAuthenticatedProcessingFilter preAuthFilter;


    @Override
    public void configure(final WebSecurity web) {
        web.ignoring()
                .mvcMatchers(TOKEN)
        ;

    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .addFilter(preAuthFilter)
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()

                .authorizeRequests()
                .anyRequest()
                .authenticated()
        ;
    }
}
