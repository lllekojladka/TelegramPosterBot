package ru.telegram.bot.security.manager.api;

import ru.telegram.bot.model.User;

public interface TokenManager {

    String generateAccessToken(User user);

    User getUser(String token);

    boolean validate(String token);
}
