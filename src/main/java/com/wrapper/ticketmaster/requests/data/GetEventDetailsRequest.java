package com.wrapper.ticketmaster.requests.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wrapper.ticketmaster.exceptions.TicketmasterWebApiException;
import com.wrapper.ticketmaster.model_objects.spec.Event;

import java.io.IOException;

@JsonDeserialize(builder = GetEventDetailsRequest.Builder.class)
public class GetEventDetailsRequest extends AbstractDataRequest<Event> {
    public GetEventDetailsRequest(final Builder builder) {
        super(builder);
    }

    @Override
    public Event execute() throws IOException, TicketmasterWebApiException {
        String jsonString = getJson();
        return new Event.JsonUtil().createModelObject(jsonString);
    }

    public static final class Builder extends AbstractDataRequest.Builder<Event, Builder> {

        public Builder(final String accessToken) { super(accessToken); }

        public Builder eventId(final String eventId) {
            return setPathParameter("id", eventId);
        }

        @Override
        public GetEventDetailsRequest build(){
            setPath("/events/{id}.json");
            return new GetEventDetailsRequest(this);
        }
    }
}
