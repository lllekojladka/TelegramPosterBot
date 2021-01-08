package ru.telegram.bot.mapper;

import org.mapstruct.Mapper;
import ru.telegram.bot.controller.model.LoginRequest;
import ru.telegram.bot.model.User;

@Mapper
public abstract class UserMapper {

   public abstract User userModel(LoginRequest loginRequest);
}
