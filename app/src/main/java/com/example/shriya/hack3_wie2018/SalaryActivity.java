package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class SalaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

        android.support.design.widget.FloatingActionButton   fab = findViewById(R.id.fab_image_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Salary_formActivity.class);
                startActivity(intent);
            }
        });


        ArrayList<Salary> salaries= new ArrayList<Salary>();
        salaries.add(new Salary("xyz","100","1000"));
        RecyclerView list = (RecyclerView) findViewById(R.id.salaryList);
        SalaryAdapter adapter = new SalaryAdapter(salaries, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));
    }
}
