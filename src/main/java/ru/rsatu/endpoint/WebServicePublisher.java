package ru.rsatu.endpoint;

import javax.xml.ws.Endpoint;
import ru.rsatu.ws.TestService;
import ru.rsatu.ws.XMLServiceImpl;

public class WebServicePublisher {
    public static void main(String... args) {
        // WS url
        Endpoint.publish("http://localhost:1488/ws/Test", new XMLServiceImpl());
    }
}


