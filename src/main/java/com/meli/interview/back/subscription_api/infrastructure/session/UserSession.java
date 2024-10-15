package com.meli.interview.back.subscription_api.infrastructure.session;

import com.meli.interview.back.subscription_api.domain.exception.CollaboratorCallException;
import com.meli.interview.back.subscription_api.domain.models.User;

public class UserSession {

    private static final UserSession userSession = new UserSession();

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() {
        throw new CollaboratorCallException(
            "UserSession.getLoggedUser() should not be called in an unit test");
    }

}
