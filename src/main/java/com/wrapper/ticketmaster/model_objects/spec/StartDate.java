package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;
import com.wrapper.ticketmaster.model_objects.IModelObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@JsonDeserialize(builder = StartDate.Builder.class)
public class StartDate extends AbstractModelObject {
    private final LocalDate localDate;
    private final LocalTime localTime;
    private final LocalDateTime localDateTime;
    private final Boolean dateTBD;
    private final Boolean dateTBA;
    private final Boolean timeTBA;
    private final Boolean noSpecificTime;

    public StartDate(Builder builder) {
        super(builder);

        this.localDate = builder.localDate;
        this.localTime = builder.localTime;
        this.localDateTime = builder.localDateTime;
        this.dateTBD = builder.dateTBD;
        this.dateTBA = builder.dateTBA;
        this.timeTBA = builder.timeTBA;
        this.noSpecificTime = builder.noSpecificTime;
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

    public Boolean getDateTBD() {
        return dateTBD;
    }

    public Boolean getDateTBA() {
        return dateTBA;
    }

    public Boolean getTimeTBA() {
        return timeTBA;
    }

    public Boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    @Override
    public IModelObject.Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private LocalDate localDate;
        private LocalTime localTime;
        private LocalDateTime localDateTime;
        private Boolean dateTBD;
        private Boolean dateTBA;
        private Boolean timeTBA;
        private Boolean noSpecificTime;

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

        public Builder setDateTBD(Boolean dateTBD) {
            this.dateTBD = dateTBD;
            return this;
        }

        public Builder setDateTBA(Boolean dateTBA) {
            this.dateTBA = dateTBA;
            return this;
        }

        public Builder setTimeTBA(Boolean timeTBA) {
            this.timeTBA = timeTBA;
            return this;
        }

        public Builder setNoSpecificTime(Boolean noSpecificTime) {
            this.noSpecificTime = noSpecificTime;
            return this;
        }

        @Override
        public StartDate build() {
            return new StartDate(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<StartDate> {

        @Override
        public StartDate createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new StartDate.Builder()
                    .setLocalDate(hasAndNotNull(jsonObject, "localDate")
                            ? LocalDate.parse(jsonObject.get("localDate").getAsString())
                            : null)
                    .setLocalTime(hasAndNotNull(jsonObject, "localTime")
                            ? LocalTime.parse(jsonObject.get("localTime").getAsString())
                            : null)
                    .setLocalDateTime(hasAndNotNull(jsonObject, "dateTime")
                            ? LocalDateTime.parse(jsonObject.get("dateTime").getAsString(), DateTimeFormatter.ISO_DATE_TIME)
                            : null)
                    .setDateTBD(hasAndNotNull(jsonObject, "dateTBD")
                            ? jsonObject.get("dateTBD").getAsBoolean()
                            : null)
                    .setDateTBA(hasAndNotNull(jsonObject, "dateTBA")
                            ? jsonObject.get("dateTBA").getAsBoolean()
                            : null)
                    .setTimeTBA(hasAndNotNull(jsonObject, "timeTBA")
                            ? jsonObject.get("timeTBA").getAsBoolean()
                            : null)
                    .setNoSpecificTime(hasAndNotNull(jsonObject, "noSpecificTime")
                            ? jsonObject.get("noSpecificTime").getAsBoolean()
                            : null)
                    .build();
        }
    }
}
