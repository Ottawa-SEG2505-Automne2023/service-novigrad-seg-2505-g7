package com.example.servicesdenovigrad;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

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


    protected User(Parcel in) {
        role = in.readString();
        name = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(role);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(password);
    }
}
