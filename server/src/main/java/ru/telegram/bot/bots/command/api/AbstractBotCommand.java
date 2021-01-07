package ru.telegram.bot.bots.command.api;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;

/**
 * Базовый класс для команд бота
 *
 * использовать совместно с интерфейсом-маркером
 */
public abstract class AbstractBotCommand extends BotCommand {

    /**
     * Construct a command
     * @param commandIdentifier the unique identifier of this command (e.g. the command string to
     *                          enter into chat)
     * @param description       the description of this command
     */
    public AbstractBotCommand(final String commandIdentifier, final String description) {
        super(commandIdentifier, description);
    }
}
