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

public class HospitalActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);



        ListView list=(ListView) findViewById(R.id.list);

         final ArrayList<String> hospital=new ArrayList<>();

        hospital.add("Apollo Health City");
        hospital.add("Yashoda Hospitals");
        hospital.add("Aware Gleneagles Global Hospital");
        hospital.add("Medicover Hospital");
        hospital.add("Citizens Hospital");
        hospital.add("Continental Hospital");
        hospital.add("Sunshine Hospital");
        hospital.add("Medicover Hospital");
        hospital.add("Global Hospital");
        hospital.add("Sunshine Hospitals");





        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,hospital);

        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(HospitalActivity.this,DepartmentActivity.class);



                String msg=hospital.get(position);

                intent.putExtra("hospitalname",msg);


                startActivity(intent);


            }
        });


    }



}
