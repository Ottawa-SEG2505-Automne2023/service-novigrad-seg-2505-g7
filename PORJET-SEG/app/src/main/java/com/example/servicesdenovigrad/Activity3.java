package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class Activity3 extends AppCompatActivity {

    Button back;

    EditText txt_userN, txt_R;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // ici le programme recoit les informations de l utilisateur qui s est connecte et affiche son username et son role dans le message de bienvenu

        User user = getIntent().getExtras().getParcelable("user_info");
        txt_userN = findViewById(R.id.txt_userN);
        txt_R = findViewById(R.id.txt_R);

        txt_userN.setText(user.getUsername());
        txt_R.setText(user.getRole());

        back = (Button) findViewById(R.id.btn_back);
        back.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
    }
}