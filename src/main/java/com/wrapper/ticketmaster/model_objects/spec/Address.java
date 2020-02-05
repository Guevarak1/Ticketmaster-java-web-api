package com.wrapper.ticketmaster.model_objects.spec;

import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

public class Address extends AbstractModelObject {
    private final String line1;
    private final String line2;
    private final String line3;

    public Address(Builder builder) {
        super(builder);
        this.line1 = builder.line1;
        this.line2 = builder.line2;
        this.line3 = builder.line3;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String line1;
        private String line2;
        private String line3;

        public Builder setLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public Builder setLine2(String line2) {
            this.line2 = line2;
            return this;
        }

        public Builder setLine3(String line3) {
            this.line3 = line3;
            return this;
        }

        @Override
        public Address build() {
            return new Address(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Address> {
        @Override
        public Address createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Address.Builder()
                    .setLine1(hasAndNotNull(jsonObject, "line1")
                            ? jsonObject.get("line1").getAsString()
                            : null)
                    .setLine2(hasAndNotNull(jsonObject, "line2")
                            ? jsonObject.get("line2").getAsString()
                            : null)
                    .setLine3(hasAndNotNull(jsonObject, "line3")
                            ? jsonObject.get("line3").getAsString()
                            : null)
                    .build();
        }
    }
}
