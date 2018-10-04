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

public class EarningActivity extends AppCompatActivity {
    public EarningActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earning);

        android.support.design.widget.FloatingActionButton fab = findViewById(R.id.fab_image_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), earning_form.class);
                startActivity(intent);
            }
        });


        ArrayList<Earning> earnings= new ArrayList<Earning>();
        earnings.add(new Earning("sdfsd","3"));
        RecyclerView list = (RecyclerView) findViewById(R.id.EarningList);
        EarningAdapter adapter = new EarningAdapter(earnings, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));

    }
}

