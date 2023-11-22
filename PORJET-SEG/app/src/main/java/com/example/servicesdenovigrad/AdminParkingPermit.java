package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminParkingPermit extends AppCompatActivity {

    Button ajout, modifier, retire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_parking_permit);

        ajout = (Button) findViewById(R.id.btn_ajout);
        modifier = (Button) findViewById(R.id.btn_modifier);
        retire = (Button) findViewById(R.id.btn_retire);

        ajout.setOnClickListener(new View.OnClickListener(){
            public void onClick ( View v){
                startActivity(new Intent(AdminParkingPermit.this, AdminIDCard.class));
                //**********A modifier la deuxieme Activite de Gouled Creation de nouveau service
            }
        });

        modifier.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Modificator md = new Modificator(0);
                Intent i = new Intent(AdminParkingPermit.this, AdminDriverLicense.class);
                i.putExtra("Modificator", md);
                startActivity(i);
            }
        });

        retire.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Modificator md = new Modificator(1);
                Intent i1 = new Intent(AdminParkingPermit.this, AdminDriverLicense.class);
                i1.putExtra("Modificator", md);
                startActivity(i1);
            }
        });
    }
}