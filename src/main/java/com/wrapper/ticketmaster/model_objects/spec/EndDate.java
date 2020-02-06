package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@JsonDeserialize(builder = EndDate.Builder.class)
public class EndDate extends AbstractModelObject {
    private final LocalDate localDate;
    private final LocalTime localTime;
    private final LocalDateTime localDateTime;
    private final Boolean noSpecificTime;

    protected EndDate(Builder builder) {
        super(builder);
        this.localDate = builder.localDate;
        this.localTime = builder.localTime;
        this.localDateTime = builder.localDateTime;
        this.noSpecificTime = builder.noSpecificTime;
    }

    public Boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private LocalDate localDate;
        private LocalTime localTime;
        private LocalDateTime localDateTime;
        private Boolean noSpecificTime;

        public Builder setNoSpecificTime(Boolean noSpecificTime) {
            this.noSpecificTime = noSpecificTime;
            return this;
        }

        public Builder setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public Builder setLocalTime(LocalTime localTime) {
            this.localTime = localTime;
            return this;
        }

        public Builder setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
            return this;
        }

        @Override
        public EndDate build() {
            return new EndDate(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<EndDate> {

        @Override
        public EndDate createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new EndDate.Builder()
                    .setLocalDate(hasAndNotNull(jsonObject, "localDate")
                            ? LocalDate.parse(jsonObject.get("localDate").getAsString())
                            : null)
                    .setLocalTime(hasAndNotNull(jsonObject, "localTime")
                            ? LocalTime.parse(jsonObject.get("localTime").getAsString())
                            : null)
                    .setLocalDateTime(hasAndNotNull(jsonObject, "localDateTime")
                            ? LocalDateTime.parse(jsonObject.get("localDateTime").getAsString())
                            : null)
                    .setNoSpecificTime(hasAndNotNull(jsonObject, "noSpecificTime")
                            ? jsonObject.get("noSpecificTime").getAsBoolean()
                            : null)
                    .build();
        }
    }
}
