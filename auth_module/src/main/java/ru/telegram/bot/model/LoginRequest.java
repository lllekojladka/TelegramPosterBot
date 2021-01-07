package ru.telegram.bot.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String userName;
    private String password;
    private String userIp;

}
