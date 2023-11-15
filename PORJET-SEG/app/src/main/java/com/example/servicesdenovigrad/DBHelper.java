package com.example.servicesdenovigrad; /***********************************************************************
 * https://youtu.be/312RhjfetP8?si=HdSoMO544uq9TdI0
 * ceci est le lien de la video duquel je me suis inspire pour ecrire ce code
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.servicesdenovigrad.Admin;
import com.example.servicesdenovigrad.Customer;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";

    public static final String COLUMN_USER_ROLE = "USER_ROLE";
    public static final String COLUMN_USER_USERNAME = "USER_USERNAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_NAME = "USER_NAME";

    // le constructeur

    public DBHelper ( Context context ){
        super ( context, "user.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTblStat = " CREATE TABLE " + USER_TABLE + " ( COLUMN_ID INTEGER PRIMARY KEY," + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_ROLE + " TEXT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT)";

        db.execSQL(createTblStat);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //la methode add ajoute les donnees d un utilisateur dans la base de donnees

    public boolean add (User user){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues cv = new ContentValues(); // cette classe permet de sotcker les elements par pair

        cv.put(COLUMN_USER_NAME, user.getName());
        cv.put(COLUMN_USER_ROLE, user.getRole());
        cv.put(COLUMN_USER_USERNAME, user.getUsername());
        cv.put(COLUMN_USER_PASSWORD, user.getPassword());

        long insert = db.insert(USER_TABLE, null, cv);
        return insert != -1;
    }

    //la methode getEveryone renvoie une la liste des utilisateurs dans la base de donnees



    // la methode find permet de trouver le compte d un utilisateur a partie de la liste de tous les utilisateurs dans la base de donne a partir de son username

    public User find( String username){


        SQLiteDatabase db = this.getReadableDatabase();

        String query = " SELECT * FROM " + USER_TABLE + " WHERE "+ COLUMN_USER_USERNAME + " = \""+ username + "\"" ;

        Cursor cursor = db.rawQuery(query, null);

        if ( cursor.moveToFirst()){
            String name = cursor.getString(1);
            String role = cursor.getString(2);
            String username1 = cursor.getString(3);
            String password = cursor.getString(4);

            if (role.equals("Administrateur")) {
                Admin user = new Admin(name, username, password);
                return user;
            } else if (role.equals("Client")) {
                Customer user = new Customer(name, username, password);
                return user;
            } else {
                Employee user = new Employee(name, username, password);
                return user;
            }

        }

        return null;

    }



}
