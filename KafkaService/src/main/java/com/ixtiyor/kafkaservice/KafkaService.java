package com.ixtiyor.kafkaservice;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaService extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:users?brokers=localhost:9092")
                .log("User ma'lumotlari: ${body}")
                .to("direct:processPayment");
    }
}
