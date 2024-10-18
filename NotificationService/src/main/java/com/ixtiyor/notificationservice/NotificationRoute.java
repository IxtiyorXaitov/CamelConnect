package com.ixtiyor.notificationservice;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:sendNotification")
                .log("Xabar jo'natish: ${body}")
                .to("http4://notification-service/send"); // Xabar yuborish
    }
}

