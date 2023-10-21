package com.vinayak09.wsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MMB extends AppCompatActivity {

    Button donor;

    TextView mmbtext;
    ImageView donor_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmb);

        donor=findViewById(R.id.donor);

        mmbtext=findViewById(R.id.MMB_text1);
        donor_img=findViewById(R.id.imageView2);


        donor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MMB.this,donor.class);
                startActivity(i);
            }
        });




    }
}