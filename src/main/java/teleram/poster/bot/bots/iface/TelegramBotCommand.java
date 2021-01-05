package teleram.poster.bot.bots.iface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import teleram.poster.bot.bots.command.iface.BotCommandAbstract;
import teleram.poster.bot.bots.command.iface.RootBotCommand;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
public abstract class TelegramBotCommand<C extends RootBotCommand> extends TelegramLongPollingCommandBot {

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


    private BotCommandAbstract logInfo(final BotCommandAbstract command) {
        log.info("{} -> register command: {}", getBotUsername(), command.getCommandIdentifier());
        return command;
    }


}
