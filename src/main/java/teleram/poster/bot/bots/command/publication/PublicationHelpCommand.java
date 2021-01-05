package teleram.poster.bot.bots.command.publication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import teleram.poster.bot.bots.command.iface.BotCommandAbstract;
import teleram.poster.bot.bots.command.iface.PublicationCommand;

@Component
@Slf4j
public class PublicationHelpCommand extends BotCommandAbstract implements PublicationCommand {

    public PublicationHelpCommand() {
        super("help", "");
    }


    @Override
    public void execute(final AbsSender absSender, final User user, final Chat chat, final String[] arguments) {
        Long id = chat.getId();
        log.info("{}: by chatId: {}",getCommandIdentifier(), id);
    }
}
