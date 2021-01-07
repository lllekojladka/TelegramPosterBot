package ru.telegram.bot.manager;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import ru.telegram.bot.manager.api.BotManager;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BotManagerImpl implements BotManager {

    private final TelegramBotsApi telegramBotsApi;

    private final List<LongPollingBot> longPollingBots;

    private List<BotSession> botSessions;


    @PostConstruct
    public void init() {
        botSessions = registerBots(longPollingBots);
    }


    private List<BotSession> registerBots(List<LongPollingBot> longPollingBots) {
        return Optional.ofNullable(longPollingBots)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::logInfo)
                .map(this::registerBot)
                .collect(Collectors.toList())
                ;
    }

    public LongPollingBot logInfo(LongPollingBot bot) {
        log.info("Register bot -> {}", bot.getBotUsername());
        return bot;
    }

    @SneakyThrows
    private BotSession registerBot(LongPollingBot longPollingBot) {
        return telegramBotsApi.registerBot(longPollingBot);
    }
}
