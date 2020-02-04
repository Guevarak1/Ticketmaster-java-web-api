package com.wrapper.ticketmaster.exceptions;

public class RequestNotFoundException extends TicketmasterWebApiException {
    public RequestNotFoundException(String message) {
        super(message);
    }
}
