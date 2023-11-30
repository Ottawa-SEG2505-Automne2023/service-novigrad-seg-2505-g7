package com.example.servicesdenovigrad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Succursale {

    public Succursale(String empl_un){
        this.empl_un = empl_un;
        serv_disp = new HashMap<>();
    }
    public Succursale(){
    }

    // les attributs

    private String empl_un;

    private Map<String, ServiceNov> serv_disp;


    public Map<String, ServiceNov> getServ_disp(){
        return serv_disp;
    }

    public boolean addService(ServiceNov e){
        if ( !serv_disp.containsKey(e.getId())) {
            serv_disp.put(e.getId(), e);
            return true;
        }
        return false;
    }

    public String getEmpl_un(){
        return empl_un;
    }

    public boolean removeService(String id){
        if ( serv_disp.containsKey(id)){
            serv_disp.remove(id);
            return true;
        }
        return false;
    }
}
