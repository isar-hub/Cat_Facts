package com.example.catfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText username,password;
    Button create,loginPage;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       username = (EditText) findViewById(R.id.email);
       password = (EditText) findViewById(R.id.password);

       create = (Button) findViewById(R.id.create);
       loginPage = (Button)  findViewById(R.id.loginPage);

       DB = new DBHelper(this);


       create.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity3.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkUser = DB.checkUserName(user);
                    if (!checkUser){
                        boolean insert = DB.insertData(user,pass);
                        if (insert){
                            Toast.makeText(MainActivity3.this,"Registered successfully ",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity3.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity3.this,"User already exists! Please sign in.",Toast.LENGTH_SHORT).show();
                    }
                }
           }
       });

       loginPage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
               startActivity(intent);
           }
       });
    }
}