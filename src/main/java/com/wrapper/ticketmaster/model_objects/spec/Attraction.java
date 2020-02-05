package com.wrapper.ticketmaster.model_objects.spec;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;
import org.w3c.dom.Attr;

@JsonDeserialize(builder = Attraction.Builder.class)
public class Attraction extends AbstractModelObject {
    private final String id;
    private final String name;
    private final String description;
    private final String additionalInfo;
    private final String url;

    public Attraction(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.additionalInfo = builder.additionalInfo;
        this.url = builder.url;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String name;
        private String description;
        private String additionalInfo;
        private String url;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        @Override
        public Attraction build() {
            return new Attraction(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Attraction> {

        @Override
        public Attraction createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Attraction.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .setDescription(hasAndNotNull(jsonObject, "description")
                            ? jsonObject.get("description").getAsString()
                            : null)
                    .setAdditionalInfo(hasAndNotNull(jsonObject, "additionalInfo")
                            ? jsonObject.get("additionalInfo").getAsString()
                            : null)
                    .build();
        }
    }
}
