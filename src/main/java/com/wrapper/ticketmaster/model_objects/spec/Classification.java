package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Classification.Builder.class)
public class Classification extends AbstractModelObject {
    private final Boolean primrary;
    private final Segment segment;
    private final Genre genre;
    private final SubGenre subGenre;
    private final Boolean family;
    private final Type type;
    private final SubType subType;

    public Classification(Builder builder) {
        super(builder);
        this.primrary = builder.primrary;
        this.segment = builder.segment;
        this.genre = builder.genre;
        this.subGenre = builder.subGenre;
        this.family = builder.family;
        this.type = builder.type;
        this.subType = builder.subType;
    }

    public Boolean getPrimrary() {
        return primrary;
    }

    public Segment getSegment() {
        return segment;
    }

    public Genre getGenre() {
        return genre;
    }

    public SubGenre getSubGenre() {
        return subGenre;
    }

    public Boolean getFamily() {
        return family;
    }

    public Type getType() {
        return type;
    }

    public SubType getSubType() {
        return subType;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private Boolean primrary;
        private Segment segment;
        private Genre genre;
        private SubGenre subGenre;
        private Boolean family;
        private Type type;
        private SubType subType;

        public Builder setPrimrary(Boolean primrary) {
            this.primrary = primrary;
            return this;
        }

        public Builder setSegment(Segment segment) {
            this.segment = segment;
            return this;
        }

        public Builder setGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder setSubGenre(SubGenre subGenre) {
            this.subGenre = subGenre;
            return this;
        }

        public Builder setFamily(Boolean family) {
            this.family = family;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setSubType(SubType subType) {
            this.subType = subType;
            return this;
        }

        @Override
        public Classification build() {
            return new Classification(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Classification> {

        @Override
        public Classification createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Classification.Builder()
                    .setPrimrary(hasAndNotNull(jsonObject, "primary")
                            ? jsonObject.get("primary").getAsBoolean()
                            : null)
                    .setFamily(hasAndNotNull(jsonObject, "family")
                            ? jsonObject.get("family").getAsBoolean()
                            : null)
                    .setSegment(hasAndNotNull(jsonObject, "segment")
                            ? new Segment.JsonUtil().createModelObject(jsonObject.get("segment").getAsJsonObject())
                            : null)
                    .setGenre(hasAndNotNull(jsonObject, "genre")
                            ? new Genre.JsonUtil().createModelObject(jsonObject.get("genre").getAsJsonObject())
                            : null)
                    .setSubGenre(hasAndNotNull(jsonObject, "subGenre")
                            ? new SubGenre.JsonUtil().createModelObject(jsonObject.get("subGenre").getAsJsonObject())
                            : null)
                    .setType(hasAndNotNull(jsonObject, "type")
                            ? new Type.JsonUtil().createModelObject(jsonObject.get("type").getAsJsonObject())
                            : null)
                    .setSubType(hasAndNotNull(jsonObject, "subType")
                            ? new SubType.JsonUtil().createModelObject(jsonObject.get("subType").getAsJsonObject())
                            : null)
                    .build();
        }
    }
}
