package ru.telegram.bot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.telegram.bot.util.AuthURLConstants;
import ru.telegram.bot.model.LoginRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TokenController {

    @PostMapping(AuthURLConstants.TOKEN)
    public ResponseEntity<String> generateToken(HttpServletRequest request,
                                                @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>("token", HttpStatus.OK);
    }


    @GetMapping(AuthURLConstants.HEALTH_CHECK)
    @ResponseStatus(HttpStatus.OK)
    public void healthCheck() {
    }
}
