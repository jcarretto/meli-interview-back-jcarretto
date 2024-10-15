package com.meli.interview.back.subscription_api.domain.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String name;

    private final List<Subscription> subscriptions = new ArrayList<Subscription>();
    private final List<User> friends = new ArrayList<User>();

    public User(String name){
        this.name = name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addSubscription(Subscription trip) {
        subscriptions.add(trip);
    }

    public List<Subscription> subscriptions() {
        return new ArrayList<Subscription>(subscriptions);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
