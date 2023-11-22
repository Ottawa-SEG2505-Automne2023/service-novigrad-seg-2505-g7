package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText name, role, username, password;

    Button create, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //les  elements remplis par le createur d un compte

        name = (EditText) findViewById(R.id.txt_Name);
        role = (EditText) findViewById(R.id.txt_Role);
        username = (EditText) findViewById(R.id.txt_Username);
        password = (EditText) findViewById(R.id.txt_Password);




// a l appui du bouton create, si les informations sont toutes remplies, une nouvel utilisateur est cree et envoye dans la base des donnees de la MainActivity
        create = (Button) findViewById(R.id.btn_create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick( View v){
                try {
                    Intent i = new Intent(Activity2.this, MainActivity.class);
                    if (role.getText().toString().equals("Administrateur")) {
                        Admin user = new Admin(name.getText().toString(), username.getText().toString(), password.getText().toString());
                        i.putExtra("user_info", user);
                    } else if (role.getText().toString().equals("Client")) {
                        Customer user = new Customer(name.getText().toString(), username.getText().toString(), password.getText().toString());
                        i.putExtra("user_info", user);
                    } else {
                        Employee user = new Employee(name.getText().toString(), username.getText().toString(), password.getText().toString());
                        i.putExtra("user_info", user);
                    }
                    Toast.makeText(Activity2.this, "Succes de creation de compte", Toast.LENGTH_SHORT).show();
                    startActivity(i);
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