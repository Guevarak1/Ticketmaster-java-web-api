package com.wrapper.ticketmaster.exceptions;

public class UnauthorizedRequestException extends TicketmasterWebApiException {
    public UnauthorizedRequestException(String errorMessage) {
        super(errorMessage);
    }
}
