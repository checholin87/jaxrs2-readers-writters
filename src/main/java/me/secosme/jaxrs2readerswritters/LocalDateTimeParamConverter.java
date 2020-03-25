package me.secosme.jaxrs2readerswritters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.ext.ParamConverter;

public class LocalDateTimeParamConverter implements ParamConverter<LocalDateTime> {

    @Override
    public LocalDateTime fromString(String value) {
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString(LocalDateTime value) {
        return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
