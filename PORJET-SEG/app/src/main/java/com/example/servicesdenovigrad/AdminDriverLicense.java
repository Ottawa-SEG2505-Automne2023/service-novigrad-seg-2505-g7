package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminDriverLicense extends AppCompatActivity {

    private DatabaseReference DB;

    EditText Sname;

    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_driver_license);

        DB = FirebaseDatabase.getInstance().getReference();

        Sname = (EditText) findViewById(R.id.txt_Sname);
        next = (Button) findViewById(R.id.btn_next);

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Modificator md = getIntent().getExtras().getParcelable("Modificator");
                // je verifie l existence du service donne
                try {
                    if (DBHelper.getService(Sname.getText().toString(), DB.child("Services")) == null) {
                        Toast.makeText(AdminDriverLicense.this, "Service inexistant ou id non valide", Toast.LENGTH_SHORT).show();
                    } else {
                        if (md.getAct() == 0) {//on renvoie a l activite de modification d un service existant
                            Intent imd = new Intent(AdminDriverLicense.this, CustomerParkingPermit.class);
                            imd.putExtra("Modificator", md);
                            startActivity(imd);
                        } else if (md.getAct() == 1) {
                            md.modif(DB.child("Services"));
                            Toast.makeText(AdminDriverLicense.this, "Operation reussie", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AdminDriverLicense.this, AdminParkingPermit.class));
                        }
                    }
                }
                catch(Exception e){ Toast.makeText(AdminDriverLicense.this, "Error", Toast.LENGTH_SHORT).show(); }



            }
        });
    }
}