package com.ixtiyor.userservice.controller;

import com.ixtiyor.userservice.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final ProducerTemplate producerTemplate;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        // Foydalanuvchini Kafka'ga yuborish
        producerTemplate.sendBody("direct:sendToKafka", user);
        return ResponseEntity.ok("Foydalanuvchi yaratildi va Kafka'ga yuborildi.");
    }
}

