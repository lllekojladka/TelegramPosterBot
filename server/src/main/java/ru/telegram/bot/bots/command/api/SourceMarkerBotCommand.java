package ru.telegram.bot.bots.command.api;

import java.util.Optional;

/**
 * Базовый интерфейс для маркеров.
 * Помечаются команды свойственные определенному боту(ам).
 */
public interface SourceMarkerBotCommand {

    default AbstractBotCommand getCommand() {
        return Optional.of(this)
                .map(AbstractBotCommand.class::cast)
                .orElseThrow();
    }
}
