package com.example.c1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class doctors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        Intent intent=getIntent();

        final String HOSNAME=intent.getStringExtra("hospn");
        final String DEPNAME=intent.getStringExtra("depar");

        ListView list1=findViewById(R.id.list1);

        final ArrayList<String> doctors=new ArrayList<>();

        doctors.add("Dr. J.M Reddy");
        doctors.add("Dr. P. Sheshagiri Rao");
        doctors.add("Dr. Jyoti Narayan Sahoo");
        doctors.add("Dr. Aslam Khan");
        doctors.add("Dr. Vijay Dikshit");
        doctors.add("Dr. Venkatesh V");
        doctors.add("Dr. Radha Shah");
        doctors.add("Dr. Ram Babu");
        doctors.add("Dr. Ramesh Vasudevan");
        doctors.add("Dr. Somasekhar M");
        doctors.add("Dr. Anuradha Panda");


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,doctors);

        list1.setAdapter(arrayAdapter);

         list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 String DOCNAME=doctors.get(position);

                 Intent intent=new Intent(doctors.this, datetime.class);

                 intent.putExtra("hspn",HOSNAME);
                 intent.putExtra("depn",DEPNAME);
                 intent.putExtra("docn",DOCNAME);

                 startActivity(intent);

             }
         });


    }
}
