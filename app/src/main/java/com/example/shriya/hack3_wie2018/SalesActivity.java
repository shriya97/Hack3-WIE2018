package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        Intent incoming = getIntent();
        String date = incoming.getStringExtra("date");

        TextView sales = findViewById(R.id.salesDetails);
        sales.setText("Sales for " + date + "is $1000");
    }
}
