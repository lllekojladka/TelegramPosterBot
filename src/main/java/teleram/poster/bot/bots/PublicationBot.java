package teleram.poster.bot.bots;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import teleram.poster.bot.bots.command.iface.PublicationCommand;
import teleram.poster.bot.bots.iface.TelegramBotCommand;
import teleram.poster.bot.config.TelegramConfig;

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
