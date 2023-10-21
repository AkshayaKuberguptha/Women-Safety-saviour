package com.vinayak09.wsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login_register extends AppCompatActivity {


    TextView Signin;

    TextView Signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        Signin = findViewById(R.id.signin);
        Signup = findViewById(R.id.signup);
    }

    public void Signin_msg(View view) {

        Intent intent = new Intent(login_register.this, login_activity.class);
        startActivity(intent);
    }


    public void Signup_msg(View view) {

        Intent intent = new Intent(login_register.this, Regiater.class);
        startActivity(intent);


    }
}