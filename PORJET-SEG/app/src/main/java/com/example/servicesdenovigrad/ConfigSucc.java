package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfigSucc extends AppCompatActivity {

    Button add, supp, mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_succ);

        add = findViewById(R.id.btn_add);
        supp = findViewById(R.id.btn_supp);
        mod = findViewById(R.id.btn_mod);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfigSucc.this, SelectService.class));
            }
        });

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (ConfigSucc.this, SuppService.class));
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (ConfigSucc.this, BusinessHours.class));
            }
        });

    }
}