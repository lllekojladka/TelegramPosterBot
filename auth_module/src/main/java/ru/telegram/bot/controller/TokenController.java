package ru.telegram.bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.telegram.bot.mapper.UserMapper;
import ru.telegram.bot.model.User;
import ru.telegram.bot.security.manager.api.AuthorizationManager;
import ru.telegram.bot.util.AuthURLConstants;
import ru.telegram.bot.controller.model.LoginRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final UserMapper userMapper;
    private final AuthorizationManager authorizationManager;

    @PostMapping(AuthURLConstants.TOKEN)
    public ResponseEntity<String> generateToken(HttpServletRequest request,
                                                @RequestBody LoginRequest loginRequest) {
        User user = userMapper.userModel(loginRequest);
        String token = authorizationManager.login(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }


    @GetMapping(AuthURLConstants.HEALTH_CHECK)
    @ResponseStatus(HttpStatus.OK)
    public void healthCheck() {
    }
}
