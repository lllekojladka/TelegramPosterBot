package ru.telegram.bot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class SecurityConfig {

    @PostConstruct
    public void init() {
        log.info("Security config -> load");
    }
}
