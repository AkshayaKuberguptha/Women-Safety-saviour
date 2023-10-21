package com.vinayak09.wsafety;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class donor extends AppCompatActivity {

    DatabaseManager databaseManager;
    private Button submit_donate,search_donate;
    private EditText name, email, age, ph_number, address, healthissue, medicationad;

    private Button select_photo;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        databaseManager=new DatabaseManager(this);
        select_photo = (Button) findViewById(R.id.pic);
        submit_donate = (Button) findViewById(R.id.Submit_donate);
        search_donate=(Button) findViewById(R.id.Search);
        name = (EditText) findViewById(R.id.name_donor);
        email = (EditText) findViewById(R.id.email_donor);
        age = (EditText) findViewById(R.id.age_donor);
        ph_number = (EditText) findViewById(R.id.ph_donor);
        address = (EditText) findViewById(R.id.address_donor);
        healthissue = (EditText) findViewById(R.id.health_issue);
        medicationad = (EditText) findViewById(R.id.medication_ad);
        adddata();
        viewdata();

    }
        public void adddata()
        {
            submit_donate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isinserted= databaseManager.insertdata(name.getText().toString(), email.getText().toString(), age.getText().toString(), ph_number.getText().toString(), address.getText().toString(), healthissue.getText().toString(), medicationad.getText().toString());
                    if(isinserted==true)
                        Toast.makeText(donor.this,"data is successfully inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(donor.this,"data is not submitted",Toast.LENGTH_LONG).show();
                }

            });

        }

    public void viewdata()
    {
        search_donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = databaseManager.getalldata();
                if (res.getCount() == 0) {
                    showmsg("Error","nothing found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id :"+res.getString(0)+"\n");
                    buffer.append("name :"+res.getString(1)+"\n");
                    buffer.append("email :"+res.getString(2)+"\n");
                    buffer.append("age :"+res.getString(3)+"\n");
                    buffer.append("health issues :"+res.getString(6)+"\n");
                    buffer.append("medication ad :"+res.getString(7)+"\n");
                }
                showmsg("Data", buffer.toString());
            }
        });
    }
    public void showmsg(String title, String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable((true));
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}