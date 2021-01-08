package ru.telegram.bot.security.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.telegram.bot.model.User;
import ru.telegram.bot.security.manager.api.AuthorizationManager;
import ru.telegram.bot.security.manager.api.TokenManager;
import ru.telegram.bot.security.manager.api.UserDetailsManager;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorizationManagerImpl implements AuthorizationManager {

    private final UserDetailsManager userDetailsManager;
    private final TokenManager tokenManager;

    @Override
    public String login(User user) {
        return tokenManager.generateAccessToken(user);
    }
}
