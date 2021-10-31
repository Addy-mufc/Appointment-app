package com.example.c1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.InputStream;

public class hosp extends AppCompatActivity {

    TextView txt;

    DatabaseReference hospi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosp);

        hospi= FirebaseDatabase.getInstance().getReference().child("data");
        hospi.keepSynced(true);
        txt=(TextView)findViewById(R.id.imptxt);

    }


}
