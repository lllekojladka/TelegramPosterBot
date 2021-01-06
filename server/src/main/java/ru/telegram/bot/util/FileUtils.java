package ru.telegram.bot.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.el.PropertyNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
@Slf4j
public class FileUtils {

    private static final ClassLoader CLASS_LOADER = FileUtils.class.getClassLoader();


    @SneakyThrows
    public Properties getProperties(String fileName) {
        log.info("Reading file: {}", fileName);
        InputStream inputStream = CLASS_LOADER.getResourceAsStream(fileName);

        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }


    public String getPropertyOrThrow(Properties properties, String property) {
        log.info("Getting property: {} from {}", property, properties);
        String value = properties.getProperty(property);
        if (StringUtils.isEmpty(value)) {
            throw new PropertyNotFoundException("Not found property: " + property);
        }
        return value;
    }
}
