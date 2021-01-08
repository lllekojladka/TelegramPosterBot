package ru.telegram.bot.config;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@Getter
public class SecurityConfig {

    private final String jwtSecret = "zlflD4JK56m6wTTgsNFhqzjqP";
    private final String jwtIssuer = "test.io";
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
    private final Long lifeTimeToken = 120L; // sek

    @Bean
    @ConditionalOnMissingBean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
