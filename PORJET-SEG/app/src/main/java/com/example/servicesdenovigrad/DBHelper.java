package com.example.servicesdenovigrad; /***********************************************************************
 *
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.servicesdenovigrad.Admin;
import com.example.servicesdenovigrad.Customer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBHelper  {

    public static void addUser(User user, DatabaseReference db){

        db.child(user.getUsername()).setValue(user);
    }

    public static void addService(ServiceNov e, DatabaseReference db){

        db.child(e.getId()).setValue(e);
    }

    public static void updateService(ServiceNov e, DatabaseReference db){

    }

    public static void updateUser(User user, DatabaseReference db){

    }

    public static User getUser(String userName, DatabaseReference db) {

        User[] userlist = new User[1];

        final User[] data = new User[1];


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()) {
                    data[0] = dt.getValue(User.class);
                    if ( data[0].getUsername() == userName){
                        break;

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
            return data[0];
        });
           

    }

    public static ServiceNov getService(String id, DatabaseReference db){

        ServiceNov[] data = new ServiceNov[1];

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()){
                    data[0] = dt.getValue(ServiceNov.class);
                    if ( data[0].getId() == id){
                        break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
            return data[0];
        });

    }

    public static void deleteService(ServiceNov e, DatabaseReference db){

        db.child(e.getId()).removeValue();
    }

    public static User getCurrentUser(DatabaseReference db){

        User[] data = new User[1];

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()) {
                    data[0] = dt.getValue(User.class);
                    break;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

            return data[0];
        });


    }

    public static void create_Serv_User(User user, ServiceNov e, DatabaseReference db){

        db.child(user.getUsername()).child(e.getId()).setValue(e);
    }
}
