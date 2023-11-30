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

         User data;


        ValueEventListener valueEventListener = db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()) {
                    data = dt.getValue(User.class);
                    if (data.getUsername() == userName) {
                        break;

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
            return data;
        });


    }

    public static ServiceNov getService(String id, DatabaseReference db){

        ServiceNov list;

        ValueEventListener valueEventListener = db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()) {
                    list = dt.getValue(ServiceNov.class);
                    if (list.getId() == id) {
                        break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
            return list;
        });

    }

    public static void deleteService(ServiceNov e, DatabaseReference db){

        db.child(e.getId()).removeValue();
    }

    public static User getCurrentUser(DatabaseReference db){

        User data;

        ValueEventListener valueEventListener = db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()) {
                    data = dt.getValue(User.class);
                    break;
                }

            }
            return data;

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


    }

    public static void create_Serv_User(User user, ServiceNov e, DatabaseReference db){

        db.child(user.getUsername()).child(e.getId()).setValue(e);
    }

    public static Succursale getSuccursale(String empl_un, DatabaseReference db){

         Succursale data;

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot){
                    data = dt.getValue(Succursale.class);
                    if (data.getEmpl_un() == empl_un){
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
            return data;
        });
    }
}
