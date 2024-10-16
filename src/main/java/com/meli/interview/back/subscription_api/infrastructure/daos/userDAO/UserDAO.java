package com.meli.interview.back.subscription_api.infrastructure.daos.userDAO;

import com.meli.interview.back.subscription_api.domain.models.User;

public interface UserDAO {
    public User create(String name);
}
