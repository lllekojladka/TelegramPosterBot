package ru.telegram.bot.bots;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.config.TelegramConfig;
import ru.telegram.bot.bots.command.iface.PublicationCommand;
import ru.telegram.bot.bots.iface.TelegramBotCommand;

@Component
@Slf4j
public class PublicationBot extends TelegramBotCommand<PublicationCommand> {


    @Override
    public String getBotUsername() {
        return TelegramConfig.BOT_NAME_PUB;
    }


    @Override
    public void processNonCommandUpdate(final Update update) {
        log.info("NonCommand: {}", update);
    }


    @Override
    public String getBotToken() {
        return TelegramConfig.BOT_APIKEY_PUB;
    }
}
