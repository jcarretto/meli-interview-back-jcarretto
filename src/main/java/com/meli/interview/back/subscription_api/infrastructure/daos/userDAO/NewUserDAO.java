package com.meli.interview.back.subscription_api.infrastructure.daos.userDAO;

import com.meli.interview.back.subscription_api.domain.models.User;

public class NewUserDAO implements UserDAO{
    public User create(String name){
        User user = new User(name);

        //persist user in db

        return user;
    }
}
