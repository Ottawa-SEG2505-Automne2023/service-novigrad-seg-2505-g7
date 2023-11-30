package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigSucc extends AppCompatActivity {

    DatabaseReference DB;

    Button add, supp, mod;

    boolean exist;

    User currentU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_succ);

        DB = FirebaseDatabase.getInstance().getReference();

        currentU = DBHelper.getCurrentUser(DB.child("CurrentUser"));

        add = findViewById(R.id.btn_add);
        supp = findViewById(R.id.btn_supp);
        mod = findViewById(R.id.btn_mod);

        exist = false;

        if ( DBHelper.getSuccursale(currentU.getUsername(), DB.child("Succursales")) != null){
            exist = true;
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(ConfigSucc.this, SelectService.class));
            }
        });

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!exist) {
                    startActivity(new Intent(ConfigSucc.this, SuppService.class));
                }
                else{
                    Toast.makeText(ConfigSucc.this, "Veuillez d'abord ajouter des services à votre succursale", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!exist) {
                    startActivity(new Intent(ConfigSucc.this, BusinessHours.class));
                }
                else{
                    Toast.makeText(ConfigSucc.this, "Veuillez d'abord ajouter des services à votre succursale", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}