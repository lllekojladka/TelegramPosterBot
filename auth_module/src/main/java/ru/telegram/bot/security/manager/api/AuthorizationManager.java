package ru.telegram.bot.security.manager.api;

import ru.telegram.bot.model.User;

public interface AuthorizationManager {

    String login(User user);
}
