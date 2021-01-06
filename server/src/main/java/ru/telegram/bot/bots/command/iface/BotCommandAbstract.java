package ru.telegram.bot.bots.command.iface;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;

/**
 * Абстрактный класс для команд бота
 */
public abstract class BotCommandAbstract extends BotCommand {

    /**
     * Construct a command
     * @param commandIdentifier the unique identifier of this command (e.g. the command string to
     *                          enter into chat)
     * @param description       the description of this command
     */
    public BotCommandAbstract(final String commandIdentifier, final String description) {
        super(commandIdentifier, description);
    }
}
