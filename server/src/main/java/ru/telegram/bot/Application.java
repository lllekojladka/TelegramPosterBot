package ru.telegram.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // telegram
        ApiContextInitializer.init();
        // spring
        SpringApplication.run(Application.class);
    }
}
