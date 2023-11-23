package com.urise.webapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.urise.webapp.model.Section;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {
    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Section.class, new JsonSectionAdapter())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {
        return gson.fromJson(reader, clazz);
    }

    public static <T> void write(T object, Writer writer) {
        gson.toJson(object, writer);
    }

    public static <T> T  read(String content, Class<T> clazz) {
        return gson.fromJson(content, clazz);
    }

    public static <T> String write(T object) {
        return gson.toJson(object);
    }

    public static <T> String write(T object, Class<T> clazz) {
        return gson.toJson(object, clazz);
    }
}