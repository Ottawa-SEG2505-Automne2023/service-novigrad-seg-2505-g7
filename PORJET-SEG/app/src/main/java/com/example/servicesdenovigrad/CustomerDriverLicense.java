package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomerDriverLicense extends AppCompatActivity {

    DatabaseReference DB;

    Button next;
    TextView SerN;
    EditText fullname, address, email, phone;

    ListView docs;

    private ServiceNov currentS, custS;

    Customer currentU;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_driver_license);



        int Snumber = getIntent().getIntExtra("Service",1);

        DB = FirebaseDatabase.getInstance().getReference().child("Services");

        currentU = (Customer) DBHelper.getCurrentUser(FirebaseDatabase.getInstance().getReference().child("CurrentUser"));

        next = findViewById(R.id.btn_crs);
        SerN = findViewById(R.id.txt_servN);
        fullname = findViewById(R.id.txt_fn);
        address = findViewById(R.id.txt_address);
        email = findViewById(R.id.txt_email);
        phone = findViewById(R.id.txt_num);


        currentS = DBHelper.getService(Integer.toString(Snumber), DB);



        custS = new ServiceNov ( currentS.getName(), currentS.getFirstD(), currentS.getSecondD(), currentS.getThirdD());

        SerN.setText(currentS.getName());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custS.setFullname(fullname.getText().toString());
                custS.setAddress(address.getText().toString());
                custS.setEmail(email.getText().toString());
                custS.setPhone(phone.getText().toString());

                currentU.addService(custS);
                //la ligne a ajouter comment enregistrer la demande d un service d un client on pourra mettre une autre classe enregistrant les demandes pour la succ
                Toast.makeText(CustomerDriverLicense.this, "Thanks, Service request received", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





        docs = (ListView)findViewById(R.id.list_docs);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(currentS.getFirstD());
        arrayList.add(currentS.getSecondD());
        arrayList.add(currentS.getThirdD());
        arrayList.add("");

        ArrayAdapter arrayAdapter = new ArrayAdapter(CustomerDriverLicense.this, android.R.layout.simple_list_item_1,arrayList);
        docs.setAdapter(arrayAdapter);

        docs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomerDriverLicense.this,"Clicked item:" + position+" "+arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });




    }
}