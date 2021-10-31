package com.example.c1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class profile2 extends AppCompatActivity {
    Button send;
    EditText txt,Contact;
    TextView t1,t2;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.send);
        txt=(EditText)findViewById(R.id.Message);
        Contact=(EditText)findViewById(R.id.phoneNumber);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Construct data
                    String apiKey = "apikey=" + "JjBq5iJHd7g-ylpKmbpNHH7KK2WKoEO9msS0ywp5KY";
                    String message = "&message=" + txt.getText().toString();
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + Contact.getText().toString();

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        Toast.makeText(profile2.this,line.toString(), Toast.LENGTH_SHORT).show();
                    }
                    rd.close();


                } catch (Exception e) {
                    Toast.makeText(profile2.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }


        });
        StrictMode.ThreadPolicy st=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(st);

    }
}
