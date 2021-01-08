package ru.telegram.bot.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthURLConstants {

    public static final String REST = "/rest";
    public static final String AUTH = "/auth";

    public static final String REST_AUTH = REST + AUTH;

    public static final String TOKEN = REST_AUTH + "/token";
    public static final String HEALTH_CHECK = REST_AUTH + "/health_check";

}
