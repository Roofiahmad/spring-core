package com.roofiahmad.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final InMemoryUserRepository repository;
    private final EmailNotificationService notification;

    public UserService(InMemoryUserRepository repository, EmailNotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }


    public void register(User user){
        repository.save(user);
        notification.send(user.name + " successfully registered ", user.email);
    }
}
