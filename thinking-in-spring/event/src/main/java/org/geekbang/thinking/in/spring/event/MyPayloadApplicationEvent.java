package org.geekbang.thinking.in.spring.event;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

public class MyPayloadApplicationEvent<String> extends PayloadApplicationEvent<String> {

    /**
     * Create a new PayloadApplicationEvent.
     *
     * @param source  the object on which the event initially occurred (never {@code null})
     * @param payload the payload object (never {@code null})
     */
    public MyPayloadApplicationEvent(Object source, String payload) {
        super(source, payload);
    }




}