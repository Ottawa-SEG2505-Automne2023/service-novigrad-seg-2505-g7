package com.example.servicesdenovigrad;

public class Customer extends User{

    // le constructeur
    public Customer( String name, String username, String password) {
        super(name, username, password);
        this.role = "Client";
    }



}
