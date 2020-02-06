package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = City.Builder.class)
public class City extends AbstractModelObject {
    private final String name;

    protected City(Builder build) {
        super(build);
        this.name = build.name;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public City build() {
            return new City(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<City> {

        @Override
        public City createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new City.Builder()
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .build();
        }
    }
}
