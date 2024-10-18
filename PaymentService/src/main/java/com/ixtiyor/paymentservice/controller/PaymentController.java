package com.ixtiyor.paymentservice.controller;

import com.ixtiyor.paymentservice.dto.PaymentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentDTO payment) {
        // To'lov jarayonini bajarish
        return ResponseEntity.ok("To'lov amalga oshirildi: " + payment);
    }
}

