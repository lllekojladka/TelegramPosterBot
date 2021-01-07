package ru.telegram.bot.bots.command.publication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.telegram.bot.bots.command.api.AbstractBotCommand;

@Component
@Slf4j
public class PublicationStartCommand extends AbstractBotCommand implements PublicationMarkerCommand {


    public PublicationStartCommand() {
        super("start", "");
    }


    @Override
    public void execute(final AbsSender absSender, final User user, final Chat chat, final String[] arguments) {
        Long id = chat.getId();
        log.info("{}: by chatId: {}", getCommandIdentifier(), id);
    }
}
