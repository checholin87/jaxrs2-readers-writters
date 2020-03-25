package me.secosme.jaxrs2readerswritters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalTime;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class LocalTimeParamConverterProvider implements ParamConverterProvider {

    @Override
    @SuppressWarnings("unchecked")
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

        if (rawType == LocalTime.class) {
            return (ParamConverter<T>) new LocalTimeParamConverter();
        }

        return null;
    }

}
