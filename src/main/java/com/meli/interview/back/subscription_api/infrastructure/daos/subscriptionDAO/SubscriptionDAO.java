package com.meli.interview.back.subscription_api.infrastructure.daos.subscriptionDAO;

import com.meli.interview.back.subscription_api.domain.models.User;
import com.meli.interview.back.subscription_api.domain.models.Subscription;

import java.util.ArrayList;

public interface SubscriptionDAO {
    public ArrayList<Subscription> findSubscriptionByUser(User user);
}
