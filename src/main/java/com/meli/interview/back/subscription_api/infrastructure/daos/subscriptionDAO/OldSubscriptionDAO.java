package com.meli.interview.back.subscription_api.infrastructure.daos.subscriptionDAO;

import com.meli.interview.back.subscription_api.domain.exception.CollaboratorCallException;
import com.meli.interview.back.subscription_api.domain.models.User;
import com.meli.interview.back.subscription_api.domain.models.Subscription;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public class OldSubscriptionDAO implements SubscriptionDAO{

    public ArrayList<Subscription> findSubscriptionByUser(User user) {
        throw new CollaboratorCallException(
            "TripDAO should not be invoked on an unit test.");
    }
}
