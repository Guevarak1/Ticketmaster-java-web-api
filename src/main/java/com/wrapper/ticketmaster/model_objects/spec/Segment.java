package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Segment.Builder.class)
public class Segment extends AbstractModelObject {
    private final String id;
    private final String name;
    private final String locale;
    private final Genre[] genres;

    public Segment(Builder builder) {
        super(builder);

        this.id = builder.id;
        this.name = builder.name;
        this.locale = builder.locale;
        this.genres = builder.genres;
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

    public Genre[] getGenres() {
        return genres;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String name;
        private String locale;
        private Genre[] genres;

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

        public Builder setGenres(Genre[] genres) {
            this.genres = genres;
            return this;
        }

        @Override
        public Segment build() {
            return new Segment(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Segment> {

        @Override
        public Segment createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Segment.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .setLocale(hasAndNotNull(jsonObject, "locale")
                            ? jsonObject.get("locale").getAsString()
                            : null)
                    .setGenres(hasAndNotNull(jsonObject, "genres")
                            ? new Genre.JsonUtil().createModelObjectArray(jsonObject.getAsJsonArray("genres"))
                            : null)
                    .build();
        }
    }
}
