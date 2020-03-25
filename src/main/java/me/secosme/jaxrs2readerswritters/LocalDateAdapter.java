package me.secosme.jaxrs2readerswritters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
