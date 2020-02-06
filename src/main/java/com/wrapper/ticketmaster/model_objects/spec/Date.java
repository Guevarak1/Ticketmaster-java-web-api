package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

@JsonDeserialize(builder = Date.Builder.class)
public class Date extends AbstractModelObject {

    private final StartDate startDate;
    private final EndDate endDate;
    private final AccessDate accessDate;
    private final String timezone;
    private final Status status;
    private final Boolean spansMultipleDays;

    public Date(Builder builder) {
        super(builder);

        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.accessDate = builder.accessDate;
        this.timezone = builder.timezone;
        this.status = builder.status;
        this.spansMultipleDays = builder.spansMultipleDays;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public AccessDate getAccessDate() {
        return accessDate;
    }

    public String getTimezone() {
        return timezone;
    }

    public Status getStatus() {
        return status;
    }

    public Boolean getSpansMultipleDays() {
        return spansMultipleDays;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private StartDate startDate;
        private EndDate endDate;
        private AccessDate accessDate;
        private String timezone;
        private Status status;
        private Boolean spansMultipleDays;

        public Builder setStartDate(StartDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(EndDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setAccessDate(AccessDate accessDate) {
            this.accessDate = accessDate;
            return this;
        }

        public Builder setTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setSpansMultipleDays(Boolean spansMultipleDays) {
            this.spansMultipleDays = spansMultipleDays;
            return this;
        }

        @Override
        public Date build() {
            return new Date(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<Date> {

        @Override
        public Date createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new Date.Builder()
                    .setStartDate(hasAndNotNull(jsonObject, "start")
                            ? new StartDate.JsonUtil().createModelObject(
                                    jsonObject.get("start").getAsJsonObject())
                            : null)
                    .setEndDate(hasAndNotNull(jsonObject, "end")
                            ? new EndDate.JsonUtil().createModelObject(
                            jsonObject.get("end").getAsJsonObject())
                            : null)
                    .setAccessDate(hasAndNotNull(jsonObject, "access")
                            ? new AccessDate.JsonUtil().createModelObject(
                            jsonObject.get("access").getAsJsonObject())
                            : null)
                    .setTimezone(hasAndNotNull(jsonObject, "timezone")
                            ? jsonObject.get("timezone").getAsString()
                            : null)
                    .setStatus(hasAndNotNull(jsonObject, "status")
                            ? new Status.JsonUtil().createModelObject(
                            jsonObject.get("status").getAsJsonObject())
                            : null)
                    .setSpansMultipleDays(hasAndNotNull(jsonObject, "spanMultipleDays")
                            ? jsonObject.get("spanMultipleDays").getAsBoolean()
                            : null)
                    .build();
        }
    }
}
