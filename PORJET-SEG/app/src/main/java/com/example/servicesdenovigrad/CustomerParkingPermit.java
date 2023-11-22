package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerParkingPermit extends AppCompatActivity {

    DatabaseReference DB;

    EditText doc1, doc2, doc3;

    Button modif;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_parking_permit);

        DB = FirebaseDatabase.getInstance().getReference();

        Modificator md = getIntent().getExtras().getParcelable("Modificator");

        doc1 = findViewById(R.id.txt_doc1);
        doc2 = findViewById(R.id.txt_doc2);
        doc3 = findViewById(R.id.txt_doc3);

        modif = findViewById(R.id.btn_modif);

        modif.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                try{
                   md.setDs(doc1.getText().toString(),
                           doc2.getText().toString(),
                           doc3.getText().toString());

                   md.modif(DB.child("Services"));
                    Toast.makeText(CustomerParkingPermit.this, "Succes de Modification", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CustomerParkingPermit.this, AdminParkingPermit.class));
                }
                catch (Exception e){
                    Toast.makeText(CustomerParkingPermit.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}