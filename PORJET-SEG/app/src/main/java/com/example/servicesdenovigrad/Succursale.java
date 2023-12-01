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

    private String num_street_postal;

    private String city;

    private String businessH;

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

    public String getNum_street_postal() {
        return num_street_postal;
    }

    public String getCity() {
        return city;
    }

    public void setNum_street_postal(String num, String street, String postal) {
        num_street_postal = num+" "+street+" "+postal;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBusinessH(){
        return businessH;
    }

    public void setBusinessH(String start, String end){
        businessH = start + " à "+ end;
    }
}
