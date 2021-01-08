package ru.telegram.bot.security.manager;

import org.springframework.stereotype.Service;
import ru.telegram.bot.model.User;
import ru.telegram.bot.security.manager.api.AbstractAuthenticatedManager;

import java.util.Optional;


@Service
public class AuthenticationManager extends AbstractAuthenticatedManager {

    // todo Работа с БД, исключения.
    @Override
    public Optional<User> authenticateByLogin(User user) {
        return Optional.ofNullable(user);
    }


    @Override
    public Optional<User> authenticateByPassword(final User user) {
        return Optional.ofNullable(user);
    }
}
