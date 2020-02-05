package com.wrapper.ticketmaster.model_objects.spec;

import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;
import com.wrapper.ticketmaster.model_objects.IModelObject;


public class Location extends AbstractModelObject {
    private final Double latitude;
    private final Double longitude;

    public Location(Builder builder) {
        super(builder);
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public IModelObject.Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private Double latitude;
        private Double longitude;

        public Builder setLatitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        @Override
        public Location build() {
            return new Location(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Location> {
        @Override
        public Location createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Location.Builder()
                    .setLatitude(hasAndNotNull(jsonObject, "latitude")
                            ? jsonObject.get("latitude").getAsDouble()
                            : null)
                    .setLongitude(hasAndNotNull(jsonObject, "longitude")
                            ? jsonObject.get("longitude").getAsDouble()
                            : null)
                    .build();
        }
    }
}
