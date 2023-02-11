package com.example.sabaq_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class Show_all extends AppCompatActivity {

    DBHandler db;
    RVAdapter adapter;
    List<Student> studentList;
    RecyclerView recyclerView;
    ArrayList<Student> studentarrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        studentarrayList=new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        studentList=db.getallnamaz();

        for(Student st:studentList)
        {
            studentarrayList.add(st);
        }
        adapter=new RVAdapter(studentarrayList);
        recyclerView.setAdapter(adapter);
    }
}