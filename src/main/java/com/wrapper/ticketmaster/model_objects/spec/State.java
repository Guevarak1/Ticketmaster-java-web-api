package com.wrapper.ticketmaster.model_objects.spec;

import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

public class State extends AbstractModelObject {
    private final String stateCode;
    private final String name;

    protected State(Builder build) {
        super(build);
        this.stateCode = build.stateCode;
        this.name = build.name;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String stateCode;
        private String name;

        public Builder setStateCode(String stateCode) {
            this.stateCode = stateCode;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public State build() {
            return new State(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<State> {

        @Override
        public State createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new State.Builder()
                    .setStateCode(hasAndNotNull(jsonObject, "stateCode")
                            ? jsonObject.get("stateCode").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .build();
        }
    }
}