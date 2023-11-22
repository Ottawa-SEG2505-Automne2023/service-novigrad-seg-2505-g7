package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminIDCard extends AppCompatActivity {

    private DatabaseReference DB;

    EditText Nom, Doc, Doc2, Doc3;

    Button cree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_idcard);

        DB = FirebaseDatabase.getInstance().getReference().child("Services");

        Nom = findViewById(R.id.txt_Nom);
        Doc = findViewById(R.id.txt_Document1);
        Doc2 = findViewById(R.id.txt_Document2);
        Doc3 = findViewById(R.id.txt_Document3);

        cree = findViewById(R.id.btn_Create);
        cree.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    ServiceNov s = new ServiceNov(Nom.getText().toString(), Doc.getText().toString(),
                            Doc2.getText().toString(),
                            Doc3.getText().toString());

                    DBHelper.addService(s, DB);
                    Toast.makeText(AdminIDCard.this, "Creation d un nouveau Service reussie", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(AdminIDCard.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}