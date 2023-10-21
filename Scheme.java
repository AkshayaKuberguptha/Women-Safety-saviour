package com.vinayak09.wsafety;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class Scheme extends AppCompatActivity {
    TextView Scheme_women;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);
        TextView linkTextView = findViewById(R.id.Scheme_1);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setLinkTextColor(Color.WHITE);

        TextView linkTextView_2 = findViewById(R.id.Scheme_2);
        linkTextView_2.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView_2.setLinkTextColor(Color.WHITE);

        TextView linkTextView_3 = findViewById(R.id.Scheme_3);
        linkTextView_3.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView_3.setLinkTextColor(Color.WHITE);

        TextView linkTextView_4 = findViewById(R.id.Scheme_4);
        linkTextView_4.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView_4.setLinkTextColor(Color.WHITE);
    }
}