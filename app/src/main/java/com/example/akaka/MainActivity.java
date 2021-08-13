package com.example.akaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button btn;
    TextView sign;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        sign = (TextView) findViewById(R.id.textSignUp);
        btn = (Button) findViewById(R.id.btnIn);
        myDB = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();



                if (user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this,"please enter credentials.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.checkUserNamePassword(user,pass);
                    if (result== true){

                        Intent intent = new Intent(getApplicationContext(),NavDrawer.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(MainActivity.this,"invalid credentials.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,account.class);
                startActivity(intent);
            }
        });



    }
}