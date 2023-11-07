package com.example.servicesdenovigrad;

public class Admin extends User{

    //le constructeur
    public Admin(String name, String username, String password) {
        super(name, username, password);
        this.role = "Administrateur";
    }
}
