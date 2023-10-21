package com.vinayak09.wsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Regiater extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    EditText UserName;
    EditText Password;
    EditText Email;
    EditText Ph_Number;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiater);

        databaseHelper = new DatabaseHelper(this);

        UserName = (EditText) findViewById(R.id.Reg_Username);
        Password = (EditText) findViewById(R.id.Reg_Password);
        Email = (EditText) findViewById(R.id.Reg_Email);
        Ph_Number = (EditText) findViewById(R.id.Reg_PhNumber);
        Submit = (Button) findViewById(R.id.Reg_Submit);

        Submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                String username = UserName.getText().toString();
                String password = Password.getText().toString();
                String email = Email.getText().toString();
                String ph_number = Ph_Number.getText().toString();

                if (username.equals("") || password.equals("") || email.equals("") || ph_number.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Required", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkusername = databaseHelper.CheckUsername(username, password, email, ph_number);
                    if (checkusername == true) {
                        Boolean insert = databaseHelper.Insert(username, password, email, ph_number);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                            UserName.setText("");
                            Password.setText("");
                            Email.setText("");
                            Ph_Number.setText("");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                    }
                }
                Intent i = new Intent(Regiater.this, Phonecall.class);
                startActivity(i);
            }



        });
    }
}

