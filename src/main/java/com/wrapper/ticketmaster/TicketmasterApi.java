package com.wrapper.ticketmaster;

import com.wrapper.ticketmaster.requests.data.GetEventDetailsRequest;

import java.util.logging.Logger;

public class TicketmasterApi {
    public static final Logger LOGGER = Logger.getLogger(TicketmasterApi.class.getName());

    public static final TicketmasterHttpManager DEFAULT_HTTP_MANAGER = new TicketmasterHttpManager();

    public static final String DEFAULT_SCHEME = "https";

    public static final String DEFAULT_HOST = "app.ticketmaster.com/discovery/v2/";

    private final IHttpManager httpManager;
    private final String scheme;
    private final String host;
    private String accessToken;

    public TicketmasterApi(Builder builder) {

        this.httpManager = builder.httpManager;
        this.scheme = builder.scheme;
        this.host = builder.host;
        this.accessToken = builder.accessToken;
    }

    public static Builder builder() {
        return new Builder();
    }

    //Requests
    public GetEventDetailsRequest.Builder getEventDetails(String eventId){
        return new GetEventDetailsRequest.Builder(accessToken)
                .eventId(eventId)
                .setDefaults(httpManager, scheme, host);
    }

    public static class Builder {

        private IHttpManager httpManager = DEFAULT_HTTP_MANAGER;
        private String scheme = DEFAULT_SCHEME;
        private String host = DEFAULT_HOST;
        private String accessToken;

        public Builder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public TicketmasterApi build() {
            return new TicketmasterApi(this);
        }
    }
}
