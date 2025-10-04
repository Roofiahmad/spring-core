package com.roofiahmad.store;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("EMAIL");
        System.out.println("Sending email: " + message);
    }
}
