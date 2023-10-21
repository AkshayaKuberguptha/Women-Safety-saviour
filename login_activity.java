package com.vinayak09.wsafety;
import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;



public class login_activity extends AppCompatActivity {

    EditText UserName;
    EditText Password;
    Button login;


    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);

        UserName = findViewById(R.id.UserName);
        Password = findViewById(R.id.Password);

        login = findViewById(R.id.Login_Button);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UserName.getText().toString();
                String password = Password.getText().toString();

                Boolean checklogin = databaseHelper.CheckLogin(username, password);
                if (checklogin == true) {
                    Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(login_activity.this,Phonecall.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid username oe password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}