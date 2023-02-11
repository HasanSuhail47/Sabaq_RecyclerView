package com.example.sabaq_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Show_list extends AppCompatActivity {
    DBHandler db;
    List<Student> studentList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RVAdapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        db = new DBHandler(this);

        studentList=db.getallnamaz();
        recyclerView=findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(Show_list.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adp=new RVAdapter(studentList);
        recyclerView.setAdapter(adp);
    }
}