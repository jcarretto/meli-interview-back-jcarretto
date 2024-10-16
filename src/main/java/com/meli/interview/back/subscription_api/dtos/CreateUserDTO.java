package com.meli.interview.back.subscription_api.dtos;

//record
public class CreateUserDTO {
    public String name;

    public CreateUserDTO(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
