package com.ixtiyor.notificationservice.controller;

import com.ixtiyor.notificationservice.dto.NotificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notification) {
        // Xabar jo'natish jarayoni
        return ResponseEntity.ok("Xabar jo'natildi: " + notification);
    }
}

