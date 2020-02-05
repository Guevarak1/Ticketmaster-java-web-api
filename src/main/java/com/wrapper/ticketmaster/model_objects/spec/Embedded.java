package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Embedded.Builder.class)
public class Embedded extends AbstractModelObject {
    private final Venue[] venues;
    private final Attraction[] attractions;

    public Embedded(Builder builder) {
        super(builder);

        this.venues = builder.venues;
        this.attractions = builder.attractions;
    }

    public Venue[] getVenues() {
        return venues;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private Venue[] venues;
        private Attraction[] attractions;

        public Builder setVenues(Venue[] venues) {
            this.venues = venues;
            return this;
        }

        public Builder setAttractions(Attraction[] attractions) {
            this.attractions = attractions;
            return this;
        }

        @Override
        public Embedded build() {
            return new Embedded(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Embedded> {

        @Override
        public Embedded createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Embedded.Builder()
                    .setVenues(hasAndNotNull(jsonObject, "venues")
                            ? new Venue.JsonUtil().createModelObjectArray(
                                    jsonObject.getAsJsonArray("venues"))
                            : null)
                    .setAttractions(hasAndNotNull(jsonObject, "attractions")
                            ? new Attraction.JsonUtil().createModelObjectArray(
                                    jsonObject.getAsJsonArray("attractions"))
                            : null)
                    .build();
        }
    }
}
