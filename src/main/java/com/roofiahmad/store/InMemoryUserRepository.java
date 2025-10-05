package com.roofiahmad.store;

import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class InMemoryUserRepository implements UserRepository{

    HashMap<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.email, user);
    }
}
