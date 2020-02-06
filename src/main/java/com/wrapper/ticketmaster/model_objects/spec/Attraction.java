package com.wrapper.ticketmaster.model_objects.spec;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Attraction.Builder.class)
public class Attraction extends AbstractModelObject {
    private final String id;
    private final String locale;
    private final String name;
    private final String description;
    private final String additionalInfo;
    private final String url;
    private final Classification[] classifications;

    public Attraction(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.locale = builder.locale;
        this.description = builder.description;
        this.additionalInfo = builder.additionalInfo;
        this.url = builder.url;
        this.classifications = builder.classifications;
    }

    public String getId() {
        return id;
    }

    public String getLocale() {
        return locale;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getUrl() {
        return url;
    }

    public Classification[] getClassifications() {
        return classifications;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String locale;
        private String name;
        private String description;
        private String additionalInfo;
        private String url;
        private Classification[] classifications;

        public Builder setLocale(String locale) {
            this.locale = locale;
            return this;
        }

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

        public Builder setClassifications(Classification[] classifications) {
            this.classifications = classifications;
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
                    .setLocale(hasAndNotNull(jsonObject, "locale")
                            ? jsonObject.get("locale").getAsString()
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
                    .setUrl(hasAndNotNull(jsonObject, "url")
                            ? jsonObject.get("url").getAsString()
                            : null)
                    .setClassifications(hasAndNotNull(jsonObject, "classifications")
                            ? new Classification.JsonUtil().createModelObjectArray(
                            jsonObject.getAsJsonArray("classifications"))
                            : null)
                    .build();
        }
    }
}
