package com.wrapper.ticketmaster.model_objects.spec;

import java.util.HashMap;
import java.util.Map;

public enum Code {

    ON_SALE("onsale"),
    OFF_SALE("offsale"),
    CANCELED("canceled"),
    POSTPONED("postponed"),
    RESCHEDULED("rescheduled");

    private static final Map<String, Code> map = new HashMap<>();

    static {
        for (Code code : Code.values()) {
            map.put(code.type, code);
        }
    }

    public final String type;

    Code(final String type) {
        this.type = type;
    }

    public static Code keyOf(String type) {
        return map.get(type);
    }

    public String getType() {
        return type;
    }
}
