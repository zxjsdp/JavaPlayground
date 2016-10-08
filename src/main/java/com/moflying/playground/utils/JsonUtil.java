package com.moflying.playground.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);
    }

    public static <T> T read(String json, Class<T> type) {
        if (null == json || null == type) {
            return null;
        }
        try {
            return mapper.readValue(json, type);
        } catch (IOException ex) {
            throw new IllegalStateException(String.format("Cannot convert json string to [%s]", type.getName()));
        }
    }

    public static <T> T read(String json, TypeReference typeReference) {
        if (null == json || null == typeReference) {
            return null;
        }
        try {
            return mapper.readValue(json, typeReference);
        } catch (IOException ex) {
            throw new IllegalStateException(String.format("Cannot convert json string to [%s]", typeReference));
        }
    }

    public static String write(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException ex) {
            throw new IllegalStateException(String.format("Cannot convert [%s] to json string", object.getClass().getName()));
        }
    }
}

class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String dateString = ((JsonNode) parser.getCodec().readTree(parser)).asText();
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

class LocalDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate date, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(DateTimeFormatter.ISO_LOCAL_DATE.format(date));
    }
}

class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String dateTimeStr = ((JsonNode) parser.getCodec().readTree(parser)).asText();
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}

class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime));
    }
}
