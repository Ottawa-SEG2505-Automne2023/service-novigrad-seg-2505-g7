package com.example.servicesdenovigrad;

import android.os.Parcelable;

public class User extends Parcelable {

    // les attributs de l utilisateur

    protected String role;
    private String name;
    private String username;
    private String password;

    //le constructeur

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    //les getteurs


    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // les setteurs
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // la methode checkPS verifie si le String passe en parametre correspond au password de l utilisateur

    public boolean checkPS (String password){
        boolean isChecked = this.password.equals(password);
        return isChecked;
    }
}
