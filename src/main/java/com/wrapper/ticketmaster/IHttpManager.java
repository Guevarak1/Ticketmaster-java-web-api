package com.wrapper.ticketmaster;

import com.wrapper.ticketmaster.exceptions.TicketmasterWebApiException;
import org.apache.http.Header;

import java.io.IOException;
import java.net.URI;

public interface IHttpManager {
    String get(URI uri, Header[] headers) throws IOException, TicketmasterWebApiException;

}
