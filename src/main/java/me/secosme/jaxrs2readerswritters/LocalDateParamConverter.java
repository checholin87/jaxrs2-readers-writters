package me.secosme.jaxrs2readerswritters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.ext.ParamConverter;

public class LocalDateParamConverter implements ParamConverter<LocalDate> {

    @Override
    public LocalDate fromString(String value) {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString(LocalDate value) {
        return value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
