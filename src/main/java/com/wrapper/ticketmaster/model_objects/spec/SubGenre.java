package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;
import com.wrapper.ticketmaster.model_objects.IModelObject;

@JsonDeserialize(builder = SubGenre.Builder.class)
public class SubGenre extends AbstractModelObject {
    private final String id;
    private final String name;
    private final String locale;

    public SubGenre(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.locale = builder.locale;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    @Override
    public IModelObject.Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String name;
        private String locale;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLocale(String locale) {
            this.locale = locale;
            return this;
        }

        @Override
        public SubGenre build() {
            return new SubGenre(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<SubGenre> {

        @Override
        public SubGenre createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new SubGenre.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .setLocale(hasAndNotNull(jsonObject, "locale")
                            ? jsonObject.get("locale").getAsString()
                            : null)
                    .build();
        }
    }
}
