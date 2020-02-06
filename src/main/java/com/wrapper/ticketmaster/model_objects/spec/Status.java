package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Status.Builder.class)
public class Status extends AbstractModelObject {

    private final Code code;

    protected Status(Builder build) {
        super(build);
        this.code = build.code;
    }

    public Code getCode() {
        return code;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private Code code;

        public Builder setCode(Code code) {
            this.code = code;
            return this;
        }

        @Override
        public Status build() {
            return new Status(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Status> {

        @Override
        public Status createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Status.Builder()
                    .setCode(hasAndNotNull(jsonObject, "code")
                            ? Code.keyOf(jsonObject.get("code").getAsString().toLowerCase())
                            : null)
                    .build();
        }
    }
}
