package com.example.servicesdenovigrad;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference DB;



    Admin user1 = new Admin ("Hilaire", "hkala", "Enfin07");

    User currentuser;


    Button connexion, create;
    TextView txt_username, txt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB = FirebaseDatabase.getInstance().getReference();

        DBHelper.addUser(user1, DB.child("User"));

        //Creation des 3 premiers services et disponibles pour le Client

        ServiceNov s1, s2, s3;

        s1 = new ServiceNov ("Demande de permis de conduire",
                "ID Card",
                "Certificat de conduite",
                "Rapport physique");

        s2 = new ServiceNov ( "Demande de Carte ID",
                "Certificat de naissance",
                "Passeport",
                "Preuve de logement");

        s3 = new ServiceNov ( "Demande de permis de parking",
                "Permis de conduire",
                "Documents du vehicule",
                "Preuve d emploi");

        DBHelper.addService(s1, DB.child("Services"));
        DBHelper.addService(s2, DB.child("Services"));
        DBHelper.addService(s3, DB.child("Services"));


        User user2;
        user2 = null;

        txt_username = (TextView) findViewById(R.id.txt_userName);
        txt_password = (TextView) findViewById(R.id.txt_password);


// D ici vers le choix de Service
        Intent i1 = new Intent(MainActivity.this, CustomerIDCard.class); // de Gouled
// D ici vers la creation de compte
        Intent i2 = new Intent( MainActivity.this, Activity2.class);
// D ici vers la page Administrateur du choix de l action a faire
        Intent i3 = new Intent(MainActivity.this, AdminParkingPermit.class);




        connexion = (Button) findViewById(R.id.btn_connect);
        connexion.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                try {

                    User user = DBHelper.getUser(txt_username.getText().toString(), DB.child("Users"));
                    if (user == null) {
                        Toast.makeText(MainActivity.this, "Compte inexistant, veuillez creer un nouveau compte", Toast.LENGTH_SHORT).show();
                    } else if (user.checkPS(txt_password.getText().toString())) {
                        DB.child("CurrentUser").setValue(user);
                        if (user.getRole() == "Administrateur") {
                            startActivity(i3);
                        } else if (user.getRole() == "Client") {
                            startActivity(i1);
                        }
                        //**************** un autre else if pour l Employee plus tard
                    } else {
                        Toast.makeText(MainActivity.this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
                catch( Exception e){
                    Toast.makeText(MainActivity.this, "Erreur, champs de texte mal rempli", Toast.LENGTH_SHORT).show();
                }

            }
        });

        create = (Button) findViewById(R.id.btn_cree);
        create.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(i2);
            }
        });
    }


}