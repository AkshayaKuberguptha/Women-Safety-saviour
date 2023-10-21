package com.vinayak09.wsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Phonecall extends AppCompatActivity {

    Button MakeCall;
    Button SOS_Service;
    TextView Textview1;
    TextView number;
    TextView Schemes;
    Button Schemes_button;
    TextView MMB;
    Button MMB_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonecall);

        number=findViewById(R.id.number);
        MakeCall=findViewById(R.id.makecall);
        SOS_Service=findViewById(R.id.SOS_Service);
        Textview1=findViewById(R.id.textview);
        Schemes=findViewById(R.id.Schemes);
        Schemes_button=findViewById(R.id.Schemes);
        MMB_button=findViewById(R.id.MMB);
        MMB=findViewById(R.id.MMB);


        MakeCall.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9345568098"));
                startActivity(intent);


        }
        });

        SOS_Service.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Phonecall.this,RegisterNumberActivity.class);
                startActivity(i);
            }
        });

        Schemes_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Phonecall.this,Scheme.class);
                startActivity(i);
            }
        });

        MMB_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Phonecall.this,MMB.class);
                startActivity(i);
            }
        });

        }
    }



