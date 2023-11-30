package com.example.servicesdenovigrad; /***********************************************************************
 * https://youtu.be/312RhjfetP8?si=HdSoMO544uq9TdI0
 * ceci est le lien de la video duquel je me suis inspire pour ecrire ce code
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
        Map<String, String> contentUser = new HashMap<>();
        contentUser.put("UserName", user.getUsername());
        contentUser.put("name", user.getName());
        contentUser.put("password", user.getPassword());
        contentUser.put("role", user.getRole());

        db.child(user.getUsername()).setValue(contentUser);
    }

    public static void addService(ServiceNov e, DatabaseReference db){
        Map<String, String> content = new HashMap<>();
        content.put("ServiceName", e.getName());
        content.put("FullName", e.getFullname());
        content.put("Adresse", e.getAddress());
        content.put("Email", e.getEmail());
        content.put("Phone", e.getPhone());
        content.put("First doc", e.getFirstD());
        content.put("Second doc", e.getSecondD());
        content.put("Third doc", e.getThirdD());

        db.child(e.getName()).setValue(content);
    }

    public static void updateService(ServiceNov e, DatabaseReference db){
        Map<String, Object> content = new HashMap<>();
        content.put("ServiceName", e.getName());
        content.put("FullName", e.getFullname());
        content.put("Adresse", e.getAddress());
        content.put("Email", e.getEmail());
        content.put("Phone", e.getPhone());
        content.put("First doc", e.getFirstD());
        content.put("Second doc", e.getSecondD());
        content.put("Third doc", e.getThirdD());

        db.child(e.getName()).updateChildren(content);
    }

    public static void updateUser(User user, DatabaseReference db){
        Map<String, Object> contentuser = new HashMap<>();
        contentuser.put("UserName", user.getUsername());
        contentuser.put("name", user.getName());
        contentuser.put("password", user.getPassword());
        contentuser.put("role", user.getRole());

        db.child(user.getUsername()).updateChildren(contentuser);
    }

    public static User getUser(String userName, DatabaseReference db) {

        User[] userlist = new User[1];


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dt : snapshot.getChildren()) {
                    // Use GenericTypeIndicator to properly deserialize HashMap
                    GenericTypeIndicator<Map<String, Object>> genericTypeIndicator = new GenericTypeIndicator<Map<String, Object>>() {};
                    Map<String, Object> data = dt.getValue(genericTypeIndicator);

                    if (data != null && data.containsKey("UserName") && data.containsKey("role")) {
                        if (userName.equals(data.get("UserName"))) {
                            String role = data.get("role").toString();
                            if ("Administrateur".equals(role)) {
                                userlist[0] = new Admin(data.get("name").toString(),
                                        data.get("UserName").toString(),
                                        data.get("password").toString());
                                break; // Exit loop once user is found
                            } else if ("Client".equals(role)) {
                                userlist[0] = new Customer(data.get("name").toString(),
                                        data.get("UserName").toString(),
                                        data.get("password").toString());
                                break; // Exit loop once user is found
                            } else {
                                userlist[0] = new Employee(data.get("name").toString(),
                                        data.get("UserName").toString(),
                                        data.get("password").toString());
                                break; // Exit loop once user is found
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
            return userlist[0];

    }

            public static ServiceNov getService(String name, DatabaseReference db){

        ServiceNov[] servicelist = new ServiceNov[1];

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> data;
                for (DataSnapshot dt : snapshot.getChildren()){
                    data = dt.getValue(HashMap.class);
                    if(data.get("ServiceName") .equals( name)){
                        servicelist[0] = new ServiceNov(data.get("ServiceName").toString(),
                                data.get("First doc").toString(),
                                data.get("Second doc").toString(),
                                data.get("Third doc").toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return servicelist[0];
    }

    public static void deleteService(ServiceNov e, DatabaseReference db){

        db.child(e.getName()).removeValue();
    }

    public static User getCurrentUser(DatabaseReference db){

        User[] userlist = new User[1];

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> data;
                for (DataSnapshot dt : snapshot.getChildren()) {
                    data = dt.getValue(HashMap.class);
                    if (data.get("role") .equals( "Administrateur")) {
                        userlist[0] = new Admin(data.get("name").toString(),
                                data.get("UserName").toString(),
                                data.get("password").toString());
                    } else if (data.get("role").equals( "Client")) {
                        userlist[0] = new Customer(data.get("name").toString(),
                                data.get("UserName").toString(),
                                data.get("password").toString());
                    } else {
                        userlist[0] = new Employee(data.get("name").toString(),
                                data.get("UserName").toString(),
                                data.get("password").toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return userlist[0];
    }

    public static void create_Serv_User(User user, ServiceNov e, DatabaseReference db){
        Map<String, String> content = new HashMap<>();
        content.put("ServiceName", e.getName());
        content.put("FullName", e.getFullname());
        content.put("Adresse", e.getAddress());
        content.put("Email", e.getEmail());
        content.put("Phone", e.getPhone());
        content.put("First doc", e.getFirstD());
        content.put("Second doc", e.getSecondD());
        content.put("Third doc", e.getThirdD());

        db.child(user.getUsername()).child(e.getName()).setValue(content);
    }
}
