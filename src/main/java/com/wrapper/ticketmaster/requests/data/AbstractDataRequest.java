package com.wrapper.ticketmaster.requests.data;

import com.wrapper.ticketmaster.requests.AbstractRequest;

public abstract class AbstractDataRequest<T> extends AbstractRequest<T> {
    protected AbstractDataRequest(final Builder<T, ?> builder) {
        super(builder);
    }

    public static abstract class Builder<T, BuilderType extends Builder<T, ?>>
            extends AbstractRequest.Builder<T, BuilderType> {
        protected Builder(String accessToken) {
            super();

            setQueryParameter("apikey", accessToken);
        }
    }
}
