package com.wrapper.ticketmaster.exceptions;

import org.apache.http.HttpException;

public class TicketmasterWebApiException extends HttpException {

    TicketmasterWebApiException(String message) {
        super(message);
    }
}
