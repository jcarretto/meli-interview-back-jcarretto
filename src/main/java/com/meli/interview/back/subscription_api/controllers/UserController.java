package com.meli.interview.back.subscription_api.controllers;

import com.meli.interview.back.subscription_api.domain.models.User;

public class UserController {

    public User createUser(String name) {
        return new User(name);
    }

}
