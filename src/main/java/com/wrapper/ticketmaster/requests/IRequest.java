package com.wrapper.ticketmaster.requests;

import com.wrapper.ticketmaster.IHttpManager;
import com.wrapper.ticketmaster.exceptions.TicketmasterWebApiException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public interface IRequest<T> {
    IHttpManager getHttpManager();

    URI getUri();

    List<Header> getHeaders();

    ContentType getContentType();

    HttpEntity getBody();

    List<NameValuePair> getBodyParameters();

    T execute() throws IOException, TicketmasterWebApiException;

    //exec async

    String getJson() throws IOException, TicketmasterWebApiException;

    //rest of verbs

    interface Builder<T, BT> {
        Builder setHttpManager(final IHttpManager httpManager);

        Builder setScheme(final String scheme);

        Builder setHost(final String host);

        Builder setPath(final String path);

        Builder setPathParameter(final String name, final String value);

        Builder setDefaults(final IHttpManager httpManager,
                            final String scheme,
                            final String host);

        <ST> Builder setQueryParameter(final String name, final ST value);

        <ST> Builder setHeader(final String name, final ST value);

        Builder setContentType(final ContentType contentType);

        Builder setBody(final HttpEntity httpEntity);

        <ST> Builder setBodyParameter(final String name, final ST value);

        AbstractRequest<T> build();

    }
}
