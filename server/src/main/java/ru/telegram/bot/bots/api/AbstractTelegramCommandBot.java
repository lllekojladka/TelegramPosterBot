package ru.telegram.bot.bots.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import ru.telegram.bot.bots.command.api.AbstractBotCommand;
import ru.telegram.bot.bots.command.api.SourceMarkerBotCommand;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Базовый класс для ботов.
 * @param <C> Маркер команд
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
public abstract class AbstractTelegramCommandBot<C extends SourceMarkerBotCommand> extends TelegramLongPollingCommandBot {


    @Autowired
    private List<C> commands;


    @PostConstruct
    public void init() {
        Optional.ofNullable(commands)
                .orElse(Collections.emptyList())
                .stream()
                .map(C::getCommand)
                .map(this::logInfo)
                .forEach(this::register);
    }


    private AbstractBotCommand logInfo(final AbstractBotCommand command) {
        log.info("{} -> register command: {}", getBotUsername(), command.getCommandIdentifier());
        return command;
    }


}
