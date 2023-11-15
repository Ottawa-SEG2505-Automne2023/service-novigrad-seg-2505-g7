package com.example.servicesdenovigrad;

import android.annotation.SuppressLint;

@SuppressLint("ParcelCreator")
public class Employee extends User{

    public Employee(String name, String username, String password) {
        super(name, username, password);
        this.role = "Employee";
    }
}
