package com.urise.webapp.util;

import com.google.gson.*;

import java.lang.reflect.Type;

public class JsonSectionAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
    private static final String CLASSNAME = "CLASSNAME"; //Class Section
    private static final String INSTANCE = "INSTANCE";// field of Section

    @Override
    public T deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);//primitive - value of classname-key
        String className = prim.getAsString();

        try {
            Class clazz = Class.forName(className);
            return context.deserialize(jsonObject.get(INSTANCE), clazz);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }

    @Override
    public JsonElement serialize(T section, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();// create empty jsonObj
        jsonObject.addProperty(CLASSNAME, section.getClass().getName()); // add {"CLASSNAME": "Section"}
        JsonElement elem = context.serialize(section);// serialisation of given section
        jsonObject.add(INSTANCE, elem);
        return jsonObject;
    }
}