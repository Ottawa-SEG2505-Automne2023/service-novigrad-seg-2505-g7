package com.example.servicesdenovigrad;

public class Employee extends User{

    public Employee(String name, String username, String password) {
        super(name, username, password);
        this.role = "Employee";
    }
}
