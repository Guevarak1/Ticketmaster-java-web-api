package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Type.Builder.class)
public class Type extends AbstractModelObject {
    private final String id;
    private final String name;
    private final String locale;
    private final SubType[] subTypes;

    public Type(Builder builder) {
        super(builder);

        this.id = builder.id;
        this.name = builder.name;
        this.locale = builder.locale;
        this.subTypes = builder.subTypes;
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

    public SubType[] getSubTypes() {
        return subTypes;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {

        private String id;
        private String name;
        private String locale;
        private SubType[] subTypes;

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

        public Builder setSubTypes(SubType[] subTypes) {
            this.subTypes = subTypes;
            return this;
        }

        @Override
        public Type build() {
            return new Type(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Type> {

        @Override
        public Type createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Type.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .setLocale(hasAndNotNull(jsonObject, "locale")
                            ? jsonObject.get("locale").getAsString()
                            : null)
                    .setSubTypes(hasAndNotNull(jsonObject, "subTypes")
                            ? new SubType.JsonUtil().createModelObjectArray(jsonObject.getAsJsonArray("subTypes"))
                            : null)
                    .build();
        }
    }
}
