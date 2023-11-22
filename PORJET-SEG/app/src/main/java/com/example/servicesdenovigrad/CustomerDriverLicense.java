package com.example.servicesdenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerDriverLicense extends AppCompatActivity {

    ListView documents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_driver_license);

        documents = (ListView)findViewById(R.id.documents_réquis);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Passeport");
        arrayList.add("Preuve de résidence au canada");
        arrayList.add("Photo 4x4");
        arrayList.add("");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        documents.setAdapter(arrayAdapter);

        documents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomerDriverLicense.this,"Clicked item:" + position+" "+arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}