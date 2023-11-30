package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SuppService extends AppCompatActivity {

    private DatabaseReference DB;
    EditText nom_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suppservice);

        DB = FirebaseDatabase.getInstance().getReference();

        nom_service = findViewById(R.id.editTextText3);

    }


}
