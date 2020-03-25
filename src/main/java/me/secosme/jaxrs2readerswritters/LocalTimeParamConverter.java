package me.secosme.jaxrs2readerswritters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.ext.ParamConverter;

public class LocalTimeParamConverter implements ParamConverter<LocalTime> {

    @Override
    public LocalTime fromString(String value) {
        return LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String toString(LocalTime value) {
        return value.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
