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
        String createTblStat = " CREATE TABLE " + USER_TABLE + " (" + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_ROLE + " TEXT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT)";

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

    public ArrayList<User> getEveryone(){
         ArrayList<User> everyone = new ArrayList<>();

         String qS = "SELECT * FROM " + USER_TABLE;

         SQLiteDatabase db = this.getReadableDatabase();

         Cursor cursor = db.rawQuery(qS);

         if (cursor.moveToFirst()) {
             //parcours le cursor (les donnees de chaque utilisateur dans la base des donnees) et cree un objet en fonction du role de l utilisateur
             do {
                 String name = cursor.getString(0);
                 String role = cursor.getString(1);
                 String username = cursor.getString(2);
                 String password = cursor.getString(3);

                 if (role == "Administrateur") {
                     Admin user = new Admin(name, username, password);
                     everyone.add(user);
                 } else if (role == "Client") {
                     Customer user = new Customer(name, username, password);
                     everyone.add(user);
                 } else {
                     Employee user = new Employee(name, username, password);
                     everyone.add(user);
                 }
             } while (cursor.moveToNext());
         }
         else {
             //rien n'est fait
         }

         cursor.close();
         db.close():
        return everyone;

    }

    // la methode find permet de trouver le compte d un utilisateur a partie de la liste de tous les utilisateurs dans la base de donne a partir de son username

    public User find( String username){
        ArrayList<User> everyone = this.getEveryone();
        for ( int i = 0; i<everyone.size(); i++)
            if (everyone.get(i).getUsername().equals(username)) return everyone.get(i);
        return null; // si il n y a aucun compte correspondant a ce username
    }
}
