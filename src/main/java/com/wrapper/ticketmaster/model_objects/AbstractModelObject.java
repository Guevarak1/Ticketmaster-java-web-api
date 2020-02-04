package com.wrapper.ticketmaster.model_objects;

import com.google.gson.*;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractModelObject implements IModelObject {
    protected AbstractModelObject(final Builder build) {

    }

    public static abstract class Builder implements IModelObject.Builder {
    }

    public static abstract class JsonUtil<T> implements IModelObject.IJsonUtil<T> {

        @Override
        public boolean hasAndNotNull(JsonObject jsonObject, String memberName) {
            return jsonObject.has(memberName) && !jsonObject.get(memberName).isJsonNull();
        }

        @Override
        public T createModelObject(String json) {
            if (json != null)
                return createModelObject(new JsonParser().parse(json).getAsJsonObject());
            return null;
        }

        @Override
        public T[] createModelObjectArray(JsonArray jsonArray) {
            T[] array = (T[]) Array.newInstance((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0], jsonArray.size());

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonElement jsonElement = jsonArray.get(i);

                if (jsonElement instanceof JsonNull) {
                    array[i] = null;
                } else {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    array[i] = createModelObject(jsonObject);
                }
            }

            return array;
        }
    }
}
