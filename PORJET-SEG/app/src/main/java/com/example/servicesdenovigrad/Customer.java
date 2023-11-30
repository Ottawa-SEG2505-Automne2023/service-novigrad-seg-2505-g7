package com.example.servicesdenovigrad;

import android.annotation.SuppressLint;

import java.util.ArrayList;

@SuppressLint("ParcelCreator")
public class Customer extends User{

    // le constructeur
    public Customer( String name, String username, String password) {
        super(name, username, password);
        this.role = "Client";
        list_serv = new ArrayList<>();
    }

    public ArrayList<ServiceNov> getList_serv(){
        return list_serv;
    }

    private ArrayList<ServiceNov> list_serv;

    public void addService(ServiceNov serv){
        list_serv.add(serv);
    }



}
