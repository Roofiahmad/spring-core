package com.roofiahmad.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{
    @Value("${email.server}")
    private String emailServer;

    @Value("${email.port}")
    private int emailPort;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("EMAIL");
        System.out.println("email server: " + emailServer);
        System.out.println("email port: " + emailPort);
        System.out.println("Sending email: " + message + "to: " + recipientEmail);
    }
}
