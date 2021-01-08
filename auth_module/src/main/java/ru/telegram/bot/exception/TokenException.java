package ru.telegram.bot.exception;

public class TokenException extends RuntimeException{

    public TokenException(final String message) {
        super(message);
    }
}
