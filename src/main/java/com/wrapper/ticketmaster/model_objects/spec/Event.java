package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;
import com.wrapper.ticketmaster.model_objects.IModelObject;

@JsonDeserialize(builder = Event.Builder.class)
public class Event extends AbstractModelObject {
    private final String id;
    private final String type;
    private final Embedded embedded;
    private final String locale;
    private final String name;
    private final String description;
    private final String additionalInfo;
    private final String url;
    private final String info;
    private final String productType;
    private final Date dates;

    protected Event(final Builder builder) {
        super(builder);

        this.id = builder.id;
        this.type = builder.type;
        this.embedded = builder.embedded;
        this.locale = builder.locale;
        this.name = builder.name;
        this.description = builder.description;
        this.additionalInfo = builder.additionalInfo;
        this.url = builder.url;
        this.info = builder.info;
        this.productType = builder.productType;
        this.dates = builder.dates;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Embedded getEmbedded() {
        return embedded;
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

    public String getInfo() {
        return info;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public IModelObject.Builder builder() {
        return new Builder();
    }

    public Date getDates() {
        return dates;
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String type;
        private Embedded embedded;
        private String locale;
        private String name;
        private String description;
        private String additionalInfo;
        private String url;
        private String info;
        private String productType;
        private Date dates;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setEmbedded(Embedded embedded) {
            this.embedded = embedded;
            return this;
        }

        public Builder setLocale(String locale) {
            this.locale = locale;
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

        public Builder setInfo(String info) {
            this.info = info;
            return this;
        }

        public Builder setProductType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder setDates(Date dates) {
            this.dates = dates;
            return this;
        }

        @Override
        public Event build() {
            return new Event(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Event> {

        @Override
        public Event createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Event.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setType(hasAndNotNull(jsonObject, "type")
                            ? jsonObject.get("type").getAsString()
                            : null)
                    .setEmbedded(hasAndNotNull(jsonObject, "_embedded")
                            ? new Embedded.JsonUtil().createModelObject(jsonObject.getAsJsonObject("_embedded"))
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
                    .setInfo(hasAndNotNull(jsonObject, "info")
                            ? jsonObject.get("info").getAsString()
                            : null)
                    .setProductType(hasAndNotNull(jsonObject, "productType")
                            ? jsonObject.get("productType").getAsString()
                            : null)
                    .setDates(hasAndNotNull(jsonObject, "dates")
                            ? new Date.JsonUtil().createModelObject(jsonObject.get("dates").getAsJsonObject())
                            : null)
                    .build();
        }
    }
}
