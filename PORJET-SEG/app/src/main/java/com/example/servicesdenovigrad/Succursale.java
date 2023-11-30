package com.example.servicesdenovigrad;

import java.util.ArrayList;
import java.util.List;

public class Succursale {

    public Succursale(String empl_un){
        this.empl_un = empl_un;
        serv_disp = new ArrayList<>();
    }
    public Succursale(){
    }

    // les attributs

    private String empl_un;

    private List<ServiceNov> serv_disp;


    public List<ServiceNov> getServ_disp(){
        return serv_disp;
    }

    public boolean addService(ServiceNov e){
        if ( !serv_disp.contains(e)) {
            serv_disp.add(e);
            return true;
        }
        return false;
    }
}
