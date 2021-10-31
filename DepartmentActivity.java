package com.example.c1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DepartmentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department2);


        Intent intent=getIntent();

        final String HOSNAME=intent.getStringExtra("hospitalname");




        ListView mylist=findViewById(R.id.mylist);

        final ArrayList<String>department=new ArrayList<>();

        department.add("Cardiology");
        department.add("Dermatology");
        department.add("ENT");
        department.add("Gastroenterology");
        department.add("General Surgery");
        department.add("Oncology");
        department.add("Orthopaedics");
        department.add("Pediatrics");
        department.add("Plastic Surgery");
        department.add("Psychiatry");
        department.add("Pulmonology");
        department.add("Vascular Surgery");


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,department);


        mylist.setAdapter(arrayAdapter);



        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(DepartmentActivity.this,doctors.class);

                String msg1=department.get(position);

                intent.putExtra("hospn",HOSNAME);
                intent.putExtra("depar",msg1);

                startActivity(intent);

            }
        });


    }
}

