package com.example.servicesdenovigrad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectService extends AppCompatActivity {

    private DatabaseReference DB;

    private User currentU;
    Button s1, s2, s3, done;

    boolean ser1, ser2, ser3;

    private Map<String, ServiceNov> serv_list;




    private Succursale succ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service);

        s1 = findViewById(R.id.btn_s1);
        s2 = findViewById(R.id.btn_s2);
        s3 = findViewById(R.id.btn_s3);
        done = findViewById(R.id.btn_done);


        DB = FirebaseDatabase.getInstance().getReference();

        currentU = DBHelper.getCurrentUser(DB.child("CurrentUser"));

        succ = new Succursale(currentU.getUsername());

        ser1 = false;
        ser2 = false;
        ser3 = false;

        serv_list = new HashMap<>();

        for ( int i = 1; i<=3; i++){// ajoute les 3 services dans une liste
            serv_list.put( Integer.toString(i),
                    DBHelper.getService(Integer.toString(i), DB.child("Services")));
        }

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ser1){
                    succ.addService(serv_list.get("1"));
                    ser1 = true;
                    Toast.makeText(SelectService.this, "Service ajouté avec succes", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SelectService.this, "Service déjà ajpouté", Toast.LENGTH_SHORT).show();
                }
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ser2){
                    succ.addService(serv_list.get("2"));
                    ser2 = true;
                    Toast.makeText(SelectService.this, "Service ajouté avec succes", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SelectService.this, "Service déjà ajpouté", Toast.LENGTH_SHORT).show();
                }
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ser3){
                    succ.addService(serv_list.get("3"));
                    ser3 = true;
                    Toast.makeText(SelectService.this, "Service ajouté avec succes", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SelectService.this, "Service déjà ajpouté", Toast.LENGTH_SHORT).show();
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.child("Succursales").child(succ.getEmpl_un()).setValue(succ);
                finish();
            }
        });


    }
}
