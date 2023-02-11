package com.example.sabaq_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText name,sabaq,sabqi,manzil;
    Button add;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHandler(this);

        name=findViewById(R.id.Name_txt);
        sabaq=findViewById(R.id.Sabaq_txt);
        sabqi=findViewById(R.id.Sabqi_txt);
        manzil=findViewById(R.id.Manzil_txt);
        add= findViewById(R.id.Add_st);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertdata(new Student(name.getText().toString(),sabaq.getText().toString(),sabqi.getText().toString(),manzil.getText().toString()));
                finish();
            }
        });
    }
}