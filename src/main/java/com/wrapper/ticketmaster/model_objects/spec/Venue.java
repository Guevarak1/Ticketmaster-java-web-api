package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Venue.Builder.class)
public class Venue extends AbstractModelObject {

    private final String id;
    private final String name;
    private final City city;
    private final State state;
    private final Country country;
    private final Address address;
    private final Location location;
    //mising: box office info, parking details, accessible seating details, general info,

    public Venue(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.city = builder.city;
        this.state = builder.state;
        this.country = builder.country;
        this.address = builder.address;
        this.location = builder.location;
    }

    public City getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public Country getCountry() {
        return country;
    }

    public Address getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private String id;
        private String name;
        private City city;
        private State state;
        private Country country;
        private Address address;
        private Location location;

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Builder setState(State state) {
            this.state = state;
            return this;
        }

        public Builder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
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

        @Override
        public Venue build() {
            return new Venue(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Venue> {

        @Override
        public Venue createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Venue.Builder()
                    .setId(hasAndNotNull(jsonObject, "id")
                            ? jsonObject.get("id").getAsString()
                            : null)
                    .setName(hasAndNotNull(jsonObject, "name")
                            ? jsonObject.get("name").getAsString()
                            : null)
                    .setCity(hasAndNotNull(jsonObject, "city")
                            ? new City.JsonUtil().createModelObject(jsonObject.getAsJsonObject("city"))
                            : null)
                    .setState(hasAndNotNull(jsonObject, "state")
                            ? new State.JsonUtil().createModelObject(jsonObject.getAsJsonObject("state"))
                            : null)
                    .setCountry(hasAndNotNull(jsonObject, "country")
                            ? new Country.JsonUtil().createModelObject(jsonObject.getAsJsonObject("country"))
                            : null)
                    .setAddress(hasAndNotNull(jsonObject, "address")
                            ? new Address.JsonUtil().createModelObject(jsonObject.getAsJsonObject("address"))
                            : null)
                    .setLocation(hasAndNotNull(jsonObject, "location")
                            ? new Location.JsonUtil().createModelObject(jsonObject.getAsJsonObject("location"))
                            : null)
                    .build();
        }
    }
}
