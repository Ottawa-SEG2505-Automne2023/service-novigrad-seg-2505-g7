package com.example.servicesdenovigrad;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

// La classe qui permet a l Administrateur de modifier ou supprimer un Service
public class Modificator {

    private int action; // 0 pour modifier et 1 pour retirer

    private String Serv_name; // qui contiendra le nom du service sur lequel apporter la modification

    // les 3 nouveaux documents requis choisi par l Administrateur

    private String firstD;
    private String secondD;
    private String thirdD;

    public Modificator(int act){
        action = act;
    }

    public String getServ_name(){
        return Serv_name;
    }

    public void setServ_name(String serv_name) {
        Serv_name = serv_name;
    }

    public void setDs(String fd, String sd, String td){
        firstD = fd;
        secondD = sd;
        thirdD = td;
    }

    public boolean modif (DatabaseReference db){
       ServiceNov serv = DBHelper.getService(Serv_name, db);
       ServiceNov serv2;
       if ( serv == null){
           return false;
       }

       if ( action == 0){
           serv2 = new ServiceNov(Serv_name, firstD, secondD, thirdD);
           DBHelper.updateService(serv2, db);
       }

       else{
           DBHelper.deleteService(serv, db);

       }

       return true; // la modification a ete effectue
    }
}
