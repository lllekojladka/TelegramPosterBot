package ru.telegram.bot.bots.command.iface;

import java.util.Optional;

/**
 * Базовый интерфейс для маркеров.
 * Помечаются команды свойственные определенному боту(ам).
 *
 * Маркеты устанавливаются на классы наследованные от BotCommandAbstract
 */
public interface RootBotCommand {

    default BotCommandAbstract getCommand() {
        return Optional.of(this)
                .map(BotCommandAbstract.class::cast)
                .orElseThrow();
    }

    default String getIdentifier() {
        return getCommand().getCommandIdentifier();
    }
}
