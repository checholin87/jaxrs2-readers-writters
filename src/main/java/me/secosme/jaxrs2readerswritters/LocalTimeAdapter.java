package me.secosme.jaxrs2readerswritters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
