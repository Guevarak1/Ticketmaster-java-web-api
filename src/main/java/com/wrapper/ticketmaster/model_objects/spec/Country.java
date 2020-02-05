package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Country.Builder.class)
public class Country extends AbstractModelObject {
    private final String name;
    private final String countryCode;

    public Country(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.countryCode = builder.countryCode;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String name;
        private String countryCode;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        @Override
        public Country build() {
            return new Country(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Country> {

        @Override
        public Country createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Country.Builder()
                    .setCountryCode(hasAndNotNull(jsonObject, "countryCode")
                            ? jsonObject.get("countryCode").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .build();
        }
    }
}
