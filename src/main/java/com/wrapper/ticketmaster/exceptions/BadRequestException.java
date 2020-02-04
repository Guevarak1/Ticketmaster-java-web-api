package com.wrapper.ticketmaster.exceptions;

public class BadRequestException extends TicketmasterWebApiException {
    public BadRequestException(String message) {
        super(message);
    }
}
