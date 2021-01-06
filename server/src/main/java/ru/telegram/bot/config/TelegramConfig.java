package ru.telegram.bot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import ru.telegram.bot.util.FileUtils;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TelegramConfig {

    private static final String PROPERTY_FILE_NAME = "telegram.properties";
    private static final String FIELD_BOT_NAME = "botName";
    private static final String FIELD_BOT_API_KEY = "botApiKey";

    private static final Properties PROPERTIES = FileUtils.getProperties(PROPERTY_FILE_NAME);

    public static final String BOT_NAME_PUB = FileUtils.getPropertyOrThrow(PROPERTIES, FIELD_BOT_NAME);
    public static final String BOT_APIKEY_PUB = FileUtils.getPropertyOrThrow(PROPERTIES, FIELD_BOT_API_KEY);


    @Bean
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi();
    }
}
