package com.roofiahmad.store;

import org.springframework.stereotype.Service;

@Service
public class NotificationManagerService {
    private final NotificationService notificationService;

    public NotificationManagerService( NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void sendNotification(String message){
        notificationService.send(message, "");
    }

}
