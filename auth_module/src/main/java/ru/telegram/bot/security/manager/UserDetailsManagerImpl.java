package ru.telegram.bot.security.manager;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.telegram.bot.security.manager.api.UserDetailsManager;

@Service
public class UserDetailsManagerImpl implements UserDetailsManager {

    @Override
    public UserDetails loadUserDetails(final PreAuthenticatedAuthenticationToken token) {
        return null;
    }
}
