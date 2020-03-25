package me.secosme.jaxrs2readerswritters;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JaxRSParamDataHolderDTOMessageBodyWriter implements MessageBodyWriter<JaxRSParamDataHolderDTO> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == JaxRSParamDataHolderDTO.class &&
            Arrays.stream(annotations).anyMatch(annotation -> annotation.annotationType() == ApplyConverter.class);
    }

    @Override
    public long getSize(JaxRSParamDataHolderDTO t, Class<?> type, Type genericType, Annotation[] annotations,
        MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(JaxRSParamDataHolderDTO t, Class<?> type, Type genericType, Annotation[] annotations,
        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream stream)
        throws IOException, WebApplicationException {

        JsonObject json = Json.createObjectBuilder()
            .add("uuid", UUID.randomUUID().toString())
            .add("date", t.getDate().toString())
            .add("time", t.getTime().toString())
            .add("timestamp", t.getTimestamp().toString())
            .build();

        try (OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8.name())) {
            writer.append(json.toString());
        }

    }

}
