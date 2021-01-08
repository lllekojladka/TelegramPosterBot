package ru.telegram.bot.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }

    @SneakyThrows
    public  <T> T fromJson(String json, Class<T> tClass) {
        return objectMapper.readValue(json, tClass);
    }

}
