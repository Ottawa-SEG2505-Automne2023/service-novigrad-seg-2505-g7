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

        name = (EditText) findViewById(R.id.txt_Name);
        role = (EditText) findViewById(R.id.txt_Role);
        username = (EditText) findViewById(R.id.txt_Username);
        password = (EditText) findViewById(R.id.txt_Password);

        // L intent qui mene au choix du service a demander apres creation d un compte Client

        Intent i = new Intent ( Activity2.this, CustomerIDCard.class); // *******de Gouled choix de service client
        Intent i1 = new Intent ( Activity2.this, AdminParkingPermit.class);




// a l appui du bouton create, si les informations sont toutes remplies, une nouvel utilisateur est cree et envoye dans la base des donnees de la MainActivity
        create = (Button) findViewById(R.id.btn_create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick( View v) {

                try {

                    if (role.getText().toString().equals("Administrateur")) {
                        user = new Admin(name.getText().toString(), username.getText().toString(), password.getText().toString());
                    } else if (role.getText().toString().equals("Client")) {
                        user = new Customer(name.getText().toString(), username.getText().toString(), password.getText().toString());

                    } else if (role.getText().toString().equals("Employee")) {
                        user = new Employee(name.getText().toString(), username.getText().toString(), password.getText().toString());
                    }
                    DBHelper.addUser(user, DB.child("Users"));
                    DB.child("CurrentUser").setValue(user);

                    Toast.makeText(Activity2.this, "Succes de creation de compte", Toast.LENGTH_SHORT).show();
                    if (user.getRole().equals("Client")) {
                        startActivity(i);
                    } else if (user.getRole().equals("Administrateur")) {
                        startActivity(i1);
                    }
                    // else vers l activite de configuration de succursale
                } catch (Exception e) {
                    Toast.makeText(Activity2.this, "Erreur, champs de texte non valide", Toast.LENGTH_SHORT).show();
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