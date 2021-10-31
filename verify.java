package com.example.c1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.TimeUnit;

public class verify extends AppCompatActivity {

    private String verificationId;
    private EditText code1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verify);





        mAuth=FirebaseAuth.getInstance();
        code1=findViewById(R.id.code);

        String phonenumber=getIntent().getStringExtra("phonenumber");


        verification(phonenumber);

        findViewById(R.id.verifybt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              
              String code=code1.getText().toString().trim();

              verifycode(code);
                
            }
        });


    }

    private void verifycode(String code){
        
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,code);
        
                signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {



                if(task.isSuccessful()){

                    Intent intent=new Intent(verify.this,profile2.class);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


                    startActivity(intent);

                }else
                {
                    Toast.makeText(verify.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private void verification(String number)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,30, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallBack);




    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationId=s;


        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code=phoneAuthCredential.getSmsCode();

            if(code!=null)
            {
                verifycode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(verify.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };


}
