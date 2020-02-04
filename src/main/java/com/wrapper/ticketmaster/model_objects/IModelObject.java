package com.wrapper.ticketmaster.model_objects;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface IModelObject {
    Builder builder();

    @JsonPOJOBuilder(withPrefix = "set")
    interface Builder {
        IModelObject build();
    }

    interface IJsonUtil<T> {

        boolean hasAndNotNull(final JsonObject jsonObject, final String memberName);

        T createModelObject(final JsonObject jsonObject);

        T createModelObject(final String json);

        T[] createModelObjectArray(final JsonArray jsonArray);

        //pagination methods
    }
}
