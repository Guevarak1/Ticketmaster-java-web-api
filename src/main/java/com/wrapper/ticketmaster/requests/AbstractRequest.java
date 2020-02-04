package com.wrapper.ticketmaster.requests;

import com.wrapper.ticketmaster.IHttpManager;
import com.wrapper.ticketmaster.TicketmasterApi;
import com.wrapper.ticketmaster.exceptions.TicketmasterWebApiException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public abstract class AbstractRequest<T> implements IRequest<T>{

    private IHttpManager httpManager;
    private URI uri;
    private List<Header> headers;
    private ContentType contentType;
    private HttpEntity body;
    private List<NameValuePair> bodyParameters;

    public AbstractRequest(Builder<T, ?> builder){
        this.httpManager = builder.httpManager;

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder
                .setScheme(builder.scheme)
                .setHost(builder.host)
                .setPath(builder.path);
        if (builder.queryParameters.size() > 0) {
            uriBuilder.setParameters(builder.queryParameters);
        }

        try {
            this.uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            TicketmasterApi.LOGGER.log(Level.SEVERE, e.getInput());
        }

        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.body = builder.body;
        this.bodyParameters = builder.bodyParameters;
    }

    @Override
    public IHttpManager getHttpManager() {
        return httpManager;
    }

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
    public List<Header> getHeaders() {
        return headers;
    }

    @Override
    public ContentType getContentType() {
        return contentType;
    }

    @Override
    public HttpEntity getBody() {
        return body;
    }

    @Override
    public List<NameValuePair> getBodyParameters() {
        return bodyParameters;
    }

    @Override
    public String getJson() throws IOException, TicketmasterWebApiException {
        String json = httpManager.get(uri, headers.toArray(new Header[0]));
        if (json == null || json.equals("")) return null;

        return json;
    }

    public static abstract class Builder<T, BT extends Builder<T, ?>> implements IRequest.Builder<T, BT> {
        private final List<NameValuePair> pathParameters = new ArrayList<>();
        private final List<NameValuePair> queryParameters = new ArrayList<>();
        private final List<Header> headers = new ArrayList<>();
        private final List<NameValuePair> bodyParameters = new ArrayList<>();
        private IHttpManager httpManager = TicketmasterApi.DEFAULT_HTTP_MANAGER;
        private String scheme = TicketmasterApi.DEFAULT_SCHEME;
        private String host = TicketmasterApi.DEFAULT_HOST;
        private String path = null;
        private ContentType contentType = null;
        private HttpEntity body = null;

        protected Builder() {

        }

        public BT setHttpManager(final IHttpManager httpManager) {
            this.httpManager = httpManager;
            return (BT) this;
        }

        public BT setScheme(final String scheme) {
            this.scheme = scheme;
            return (BT) this;
        }

        public BT setHost(final String host) {
            this.host = host;
            return (BT) this;
        }

        public BT setPath(final String path) {
            String builtPath = path;

            for (NameValuePair nameValuePair : pathParameters) {
                builtPath = builtPath.replaceAll("\\{" + nameValuePair.getName() + "}", nameValuePair.getValue());
            }

            this.path = builtPath;
            return (BT) this;
        }

        public BT setPathParameter(final String name, final String value) {
            String encodedValue = null;

            try {
                encodedValue = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                TicketmasterApi.LOGGER.log(Level.SEVERE, e.getMessage());
            }

            addValuePair(this.pathParameters, new BasicNameValuePair(name, encodedValue));
            return (BT) this;
        }

        public BT setDefaults(final IHttpManager httpManager, final String scheme,
                              final String host) {
            setHttpManager(httpManager);
            setScheme(scheme);
            setHost(host);

            return (BT) this;
        }

        public <X> BT setQueryParameter(final String name, final X value) {
            addValuePair(this.queryParameters, new BasicNameValuePair(name, String.valueOf(value)));
            return (BT) this;
        }

        public <X> BT setHeader(final String name, final X value) {
            headers.removeIf(header -> header.getName().equals(name));
            headers.add(new BasicHeader(name, String.valueOf(value)));
            return (BT) this;
        }

        public BT setContentType(final ContentType contentType) {
            this.contentType = contentType;
            setHeader("Content-Type", contentType.getMimeType());
            return (BT) this;
        }

        public BT setBody(final HttpEntity httpEntity) {
            this.body = httpEntity;
            return (BT) this;
        }

        public <X> BT setBodyParameter(final String name, final X value) {
            addValuePair(this.bodyParameters, new BasicNameValuePair(name, String.valueOf(value)));
            return (BT) this;
        }

        private void addValuePair(List<NameValuePair> parameters, BasicNameValuePair basicNameValuePair) {
            parameters.removeIf(nameValuePair -> nameValuePair.getName().equals(basicNameValuePair.getName()));
            parameters.add(basicNameValuePair);
        }
    }
}
