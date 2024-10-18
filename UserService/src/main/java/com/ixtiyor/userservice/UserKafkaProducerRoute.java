package com.ixtiyor.userservice;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserKafkaProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:sendToKafka")
                .log("Foydalanuvchi Kafka'ga yuborilmoqda: ${body}")
                .to("kafka:users?brokers=localhost:9092");
    }
}

