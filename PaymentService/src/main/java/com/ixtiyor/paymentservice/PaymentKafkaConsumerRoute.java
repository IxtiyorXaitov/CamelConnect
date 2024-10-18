package com.ixtiyor.paymentservice;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PaymentKafkaConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:users?brokers=localhost:9092")
                .log("Kafka'dan olingan foydalanuvchi: ${body}")
                .to("direct:processPayment"); // To'lov jarayonini boshqarish
    }
}

