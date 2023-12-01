package com.example.servicesdenovigrad;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BusinessHours extends AppCompatActivity {

    EditText num, street, city, postal, startH, endH;

    Button register;

    private DatabaseReference DB;

    Succursale succ;

    User currentU;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_hours);

        DB = FirebaseDatabase.getInstance().getReference();

        currentU = DBHelper.getCurrentUser(DB.child("CurrentUser"));
        succ = DBHelper.getSuccursale(currentU.getUsername(), DB.child("Succursales"));

        num = findViewById(R.id.txt_numa);
        street = findViewById(R.id.txt_street);
        city = findViewById(R.id.txt_city);
        postal = findViewById(R.id.txt_postal);
        startH = findViewById(R.id.txt_start);
        endH = findViewById(R.id.txt_end);

        register = findViewById(R.id.btn_reg);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    succ.setCity(city.getText().toString());
                    succ.setNum_street_postal(num.getText().toString(), street.getText().toString(), postal.getText().toString());
                    succ.setBusinessH(startH.getText().toString(), endH.getText().toString());
                    DB.child("Succursales").child(currentU.getUsername()).setValue(succ);
                    Toast.makeText(BusinessHours.this, "Informations de la succursale mises à jour", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(BusinessHours.this, "Erreur, champs de texte non valide", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}
