package com.meli.interview.back.subscription_api.services;

import com.meli.interview.back.subscription_api.domain.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.domain.models.Subscription;
import com.meli.interview.back.subscription_api.domain.models.User;
import com.meli.interview.back.subscription_api.infrastructure.session.UserSession;
import com.meli.interview.back.subscription_api.infrastructure.daos.subscriptionDAO.SubscriptionDAO;

import java.util.ArrayList;
import java.util.List;

/*
public class SubscriptionService {

    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado
     * se encuentre en su lista de amigos
     * @param user
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado

    public Float getUserSubscriptionsCost(User user) throws UserNotLoggedInException {
        ArrayList<Subscription> subscriptionList = new ArrayList<Subscription>();

        // get logged user
        User loggedUser = UserSession.getInstance().getLoggedUser();
        boolean isFriend = false;
        if (loggedUser != null) {
            for (User friend : user.getFriends()) {
                if (friend == loggedUser) {
                    isFriend = true;
                    break;
                }
            }
            if (isFriend) {
                subscriptionList = SubscriptionDAO.findSubscriptionByUser(user);
            }

            float totalPrice = 0;

            for (Subscription subscription : subscriptionList) {
                totalPrice += subscription.getPrice();
            }

            return totalPrice;
        } else {
            throw new UserNotLoggedInException();
        }
    }
}
*/

public class SubscriptionService {

    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionService(SubscriptionDAO subscriptionDAO){
        this.subscriptionDAO = subscriptionDAO;
    }

    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado
     * se encuentre en su lista de amigos
     * @param user
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado
     */
    public Float getUserSubscriptionsCost(User user) throws UserNotLoggedInException {
        ArrayList<Subscription> subscriptionList = new ArrayList<Subscription>();

        User loggedUser = UserSession.getInstance().getLoggedUser();

        if (loggedUser != null) {
            if (isFriend(loggedUser, user)) {
                subscriptionList = subscriptionDAO.findSubscriptionByUser(user);
            }
            return totalPrice(subscriptionList);

        } else {
            throw new UserNotLoggedInException();
        }
    }

    private boolean isFriend(User user, User possibleFriend){
        return user
                .getFriends()
                .contains(possibleFriend);
    }

    private float totalPrice(List<Subscription> subscriptions){
        float totalPrice = 0;

        for (Subscription subscription : subscriptions) {
            totalPrice += subscription.getPrice();
        }

        return totalPrice;
    }
}
