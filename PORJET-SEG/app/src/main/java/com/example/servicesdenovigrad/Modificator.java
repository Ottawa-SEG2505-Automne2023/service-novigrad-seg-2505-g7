package com.example.servicesdenovigrad;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

// La classe qui permet a l Administrateur de modifier ou supprimer un Service
public class Modificator implements Parcelable {

    private int action; // 0 pour modifier et 1 pour retirer

    private String Serv_name; // qui contiendra le nom du service sur lequel apporter la modification

    // les 3 nouveaux documents requis choisi par l Administrateur

    private String firstD;
    private String secondD;
    private String thirdD;

    public Modificator(int act){
        action = act;
    }

    protected Modificator(Parcel in) {
        action = in.readInt();
        Serv_name = in.readString();
        firstD = in.readString();
        secondD = in.readString();
        thirdD = in.readString();
    }

    public static final Creator<Modificator> CREATOR = new Creator<Modificator>() {
        @Override
        public Modificator createFromParcel(Parcel in) {
            return new Modificator(in);
        }

        @Override
        public Modificator[] newArray(int size) {
            return new Modificator[size];
        }
    };

    public String getServ_name(){
        return Serv_name;
    }

    public int getAct(){ return action; }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(action);
        dest.writeString(Serv_name);
        dest.writeString(firstD);
        dest.writeString(secondD);
        dest.writeString(thirdD);
    }
}
