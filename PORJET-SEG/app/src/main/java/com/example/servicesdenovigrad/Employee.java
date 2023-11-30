package com.example.servicesdenovigrad;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ParcelCreator")
public class Employee extends User{

    //la liste contenat la liste des services offerts par la succursale de cte employe



    public Employee(String name, String username, String password) {
        super(name, username, password);
        this.role = "Employee";
    }


 }
