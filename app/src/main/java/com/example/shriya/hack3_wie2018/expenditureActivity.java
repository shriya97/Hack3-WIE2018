package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Priyanka on 10/5/2018.
 */

public class expenditureActivity extends AppCompatActivity{
    public expenditureActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenditure);

        android.support.design.widget.FloatingActionButton fab = findViewById(R.id.fab_image_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), expenditure_form.class);
                startActivity(intent);
            }
        });


        ArrayList<expenditure>expenditures= new ArrayList<expenditure>();
        expenditures.add(new expenditure("sdfsd","3"));
        RecyclerView list = (RecyclerView) findViewById(R.id.expenditureList);
        expenditureAdapter adapter = new expenditureAdapter(expenditures, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));

    }
}
