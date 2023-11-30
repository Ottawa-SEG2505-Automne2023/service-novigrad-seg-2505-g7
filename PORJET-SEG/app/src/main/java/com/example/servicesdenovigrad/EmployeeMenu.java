package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class EmployeeMenu extends AppCompatActivity {
    Button Configurer;
    Button Voir;
    TextView faire;

    Intent i1 = new Intent(EmployeeMenu.this, ConfigSucc.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeemenu);


        Configurer = (Button) findViewById(R.id.btn_Configurer);
        Voir = (Button) findViewById(R.id.btn_Voir);

        Configurer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
            }

        });

        Voir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//****************************************************************************
            }
        });

    }
}

