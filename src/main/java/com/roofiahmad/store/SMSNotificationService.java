package com.roofiahmad.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary
public class SMSNotificationService implements NotificationService{
    public void send(String message) {
        System.out.println("SMS");
        System.out.println("Sending SMS: " + message);
    }
}
