package com.example.servicesdenovigrad;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper db = new DBHelper( MainActivity.this );

    Admin user1 = new Admin ("Hilaire", "hkala", "Enfin07");





    Button connexion, create;
    TextView txt_username, txt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.add( user1);

        User user2;
        user2 = null;



        try{
            user2 = getIntent().getExtras().getParcelable("user_info");
        }
        catch(Exception e){

        }

        txt_username = (TextView) findViewById(R.id.txt_userName);
        txt_password = (TextView) findViewById(R.id.txt_ps);



        // enregistre le compte nouvellement cree dans la base de donnees
        if ( user2 != null){
            db.add(user2);
        }



        Intent i1 = new Intent(MainActivity.this, Activity3.class);
        Intent i2 = new Intent( MainActivity.this, Activity2.class);


        connexion = (Button) findViewById(R.id.btn_connect);
        connexion.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                try{
                    User user = db.find(txt_username.getText().toString());
                    if (user == null) {
                        Toast.makeText(MainActivity.this, "Compte inexistant, veuillez creer un nouveau compte", Toast.LENGTH_SHORT).show();
                    } else if (user.checkPS(txt_password.getText().toString())) {
                        i1.putExtra("user_info", user);
                        startActivity(i1);
                    } else {
                        Toast.makeText(MainActivity.this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                } catch ( Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
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