package com.wrapper.ticketmaster.model_objects.spec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonObject;
import com.wrapper.ticketmaster.model_objects.AbstractModelObject;

import java.time.LocalDateTime;

@JsonDeserialize(builder = AccessDate.Builder.class)
public class AccessDate extends AbstractModelObject {
    private final LocalDateTime startDateTime;
    private final Boolean startApproximate;
    private final LocalDateTime endDateTime;
    private final Boolean endApproximate;

    public AccessDate(Builder builder) {
        super(builder);

        this.startDateTime = builder.startDateTime;
        this.startApproximate = builder.startApproximate;
        this.endDateTime = builder.endDateTime;
        this.endApproximate = builder.endApproximate;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public Boolean getStartApproximate() {
        return startApproximate;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Boolean getEndApproximate() {
        return endApproximate;
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractModelObject.Builder {
        private LocalDateTime startDateTime;
        private Boolean startApproximate;
        private LocalDateTime endDateTime;
        private Boolean endApproximate;

        public Builder setStartDateTime(LocalDateTime startDateTime) {
            this.startDateTime = startDateTime;
            return this;
        }

        public Builder setStartApproximate(Boolean startApproximate) {
            this.startApproximate = startApproximate;
            return this;
        }

        public Builder setEndDateTime(LocalDateTime endDateTime) {
            this.endDateTime = endDateTime;
            return this;
        }

        public Builder setEndApproximate(Boolean endApproximate) {
            this.endApproximate = endApproximate;
            return this;
        }

        @Override
        public AccessDate build() {
            return new AccessDate(this);
        }
    }

    public static final class JsonUtil extends AbstractModelObject.JsonUtil<AccessDate> {

        @Override
        public AccessDate createModelObject(JsonObject jsonObject) {
            if (jsonObject == null || jsonObject.isJsonNull()) {
                return null;
            }

            return new AccessDate.Builder()
                    .setStartDateTime(hasAndNotNull(jsonObject, "startDateTime")
                            ? LocalDateTime.parse(jsonObject.get("startDateTime").getAsString())
                            : null)
                    .setEndDateTime(hasAndNotNull(jsonObject, "endDateTime")
                            ? LocalDateTime.parse(jsonObject.get("endDateTime").getAsString())
                            : null)
                    .setStartApproximate(hasAndNotNull(jsonObject, "startApproximate")
                            ? jsonObject.get("startApproximate").getAsBoolean()
                            : null)
                    .setEndApproximate(hasAndNotNull(jsonObject, "endApproximate")
                            ? jsonObject.get("endApproximate").getAsBoolean()
                            : null)
                    .build();
        }
    }
}
