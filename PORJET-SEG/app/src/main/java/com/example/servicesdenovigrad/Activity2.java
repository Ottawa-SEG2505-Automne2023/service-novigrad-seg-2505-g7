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

public class Activity2 extends AppCompatActivity {

    private DatabaseReference DB;

 private User user;

    EditText name, role, username, password;

    Button create, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        DB = FirebaseDatabase.getInstance().getReference();

        //les  elements remplis par le createur d un compte

        name = findViewById(R.id.txt_Name);
        role = findViewById(R.id.txt_Role);
        username = findViewById(R.id.txt_Username);
        password = findViewById(R.id.txt_Password);




// a l appui du bouton create, si les informations sont toutes remplies, une nouvel utilisateur est cree et envoye dans la base des donnees de la MainActivity
        create = (Button) findViewById(R.id.btn_create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick( View v){
                try {
                    if (role.getText().toString() == "Administrateur") {
                         user = new Admin(name.getText().toString(), username.getText().toString(), password.getText().toString());
                    } else if (role.getText().toString().equals("Client")) {
                         user = new Customer(name.getText().toString(), username.getText().toString(), password.getText().toString());
                        
                    } else {
                         user = new Employee(name.getText().toString(), username.getText().toString(), password.getText().toString());
                    }
                    DBHelper.addUser(user, DB.child("Users"));
                    Toast.makeText(Activity2.this, "Succes de creation de compte", Toast.LENGTH_SHORT).show();
                    finish();
                }
                catch( Exception e){
                    Toast.makeText(Activity2.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

        });

        back = (Button) findViewById(R.id.btn_return);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick( View v){
                finish();
            }
        });
    }
}