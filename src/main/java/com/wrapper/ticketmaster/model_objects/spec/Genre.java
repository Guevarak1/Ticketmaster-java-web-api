package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Genre.Builder.class)
public class Genre extends AbstractModelObject {
    private final String id;
    private final String name;
    private final String locale;
    private final SubGenre[] subGenres;

    public Genre(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.locale = builder.locale;
        this.subGenres = builder.subGenres;
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

    public SubGenre[] getSubGenres() {
        return subGenres;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String name;
        private String locale;
        private SubGenre[] subGenres;

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

        public Builder setSubGenres(SubGenre[] subGenres) {
            this.subGenres = subGenres;
            return this;
        }

        @Override
        public Genre build() {
            return new Genre(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Genre> {

        @Override
        public Genre createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Genre.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .setLocale(hasAndNotNull(jsonObject, "locale")
                            ? jsonObject.get("locale").getAsString()
                            : null)
                    .setSubGenres(hasAndNotNull(jsonObject, "subGenres")
                            ? new SubGenre.JsonUtil().createModelObjectArray(
                                    jsonObject.getAsJsonArray("subGenres"))
                            : null)
                    .build();
        }
    }
}
