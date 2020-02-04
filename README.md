# Ticketmaster-java-web-api
Java wrapper for Ticketmaster's API

Usage:

    TicketmasterApi api = TicketmasterbriteApi
            .builder()
            .setAccessToken(ACCESS_TOKEN)
            .build();

    GetEventDetailsRequest eventDetailsRequest = api.getEventDetails("vvG1FZ4cE51B7t").build();

    try {
        Event eventResponse = eventDetailsRequest.execute();
        System.out.println(eventResponse.getId());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
