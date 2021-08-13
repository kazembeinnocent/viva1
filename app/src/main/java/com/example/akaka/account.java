package com.example.akaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class account extends AppCompatActivity {

    TextView SignUp,conf;
    Button btnLog,btnSubmit;
    EditText username,password,confirmPass;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        confirmPass = (EditText)findViewById(R.id.confPass);
        btnLog = (Button)findViewById(R.id.btnIn);
        btnSubmit = (Button)findViewById(R.id.btn1);
        SignUp= (TextView)findViewById(R.id.textSignUp);
        myDB = new DBHelper(this);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confPass = confirmPass.getText().toString();

                if (user.equals("") || pass.equals("") || confPass.equals("")){
                    Toast.makeText(account.this,"Fill all Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(confPass)){
                        Boolean userCheckResult = myDB.checkUserName(user);
                        if (userCheckResult == false){
                            Boolean signUpResult = myDB.insertData(user,pass);

                            if (signUpResult == true){
                                Toast.makeText(account.this,"Sign Up successfully.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(account.this,MainActivity.class);
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(account.this,"Sign Up failed.",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(account.this,"User already exists\n Sign In.",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(account.this,"The password does not match.",Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

    }
}