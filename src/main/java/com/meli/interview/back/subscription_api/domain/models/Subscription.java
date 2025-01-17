package com.meli.interview.back.subscription_api.domain.models;

/*
public class Subscription {
    private String partner;

    public float getPrice() {
        float price = 0;
        if (partner.equals("disney")) {
            price = 100;
        }

        if (partner.equals("netflix")) {
            price = 200;
        }

        if (partner.equals("spotify")) {
            price = 50;
        } else {
            price = 0;
        }

        return price;
     }
}
*/

public class Subscription {
    private final String partner;
    private float price;

    public Subscription(String partner, float price){
        this.partner = partner;
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public String getPartner(){
        return this.partner;
    }
}
