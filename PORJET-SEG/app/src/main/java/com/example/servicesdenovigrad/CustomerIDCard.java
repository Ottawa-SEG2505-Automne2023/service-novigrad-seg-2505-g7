package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerIDCard extends AppCompatActivity {
    Button Conduite, ID, Parking;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_idcard);

        Intent i = new Intent ( CustomerIDCard.this, CustomerDriverLicense.class);

        Conduite = findViewById(R.id.btn_Conduite);
        ID = findViewById(R.id.btn_ID);
        Parking = findViewById(R.id.btn_Parking);

        Conduite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                i.putExtra("Service", 1);
                startActivity(i);
            }
        });
        ID.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                i.putExtra("Service", 2);
                startActivity(i);
            }
        });

        Parking.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                i.putExtra("Service", 3);
                startActivity(i);
            }
        });

    }
}