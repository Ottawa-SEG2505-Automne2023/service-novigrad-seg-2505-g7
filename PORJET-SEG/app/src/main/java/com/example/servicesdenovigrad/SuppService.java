package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SuppService extends AppCompatActivity {

    private DatabaseReference DB;
    EditText id_service;

    Button del;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suppservice);

        final Succursale[] succ = new Succursale[1];

        DB = FirebaseDatabase.getInstance().getReference();

        id_service = findViewById(R.id.editTextText3);
        del = findViewById(R.id.btn_del);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    succ[0] = DBHelper.getSuccursale(DBHelper.getCurrentUser(DB.child("CurrentUser")).getUsername(),
                            DB.child("Succursales"));
                    if ( !succ[0].removeService(id_service.getText().toString())){
                        Toast.makeText(SuppService.this, "Aucun service ayant cet id ou id non valide", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        DB.child("Succursales").child(succ[0].getEmpl_un()).setValue(succ[0]);
                        Toast.makeText(SuppService.this, "Service retirée de la succursale avec succes", Toast.LENGTH_SHORT).show();
                    }

                }catch ( Exception e){
                    Toast.makeText(SuppService.this, "Une erreur est survenue", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
