package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class BusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        TextView salesView = findViewById(R.id.sales);

        salesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salesIntent = new Intent(BusinessActivity.this, CalendarActivity.class);
                startActivity(salesIntent);
            }
        });
    }
}
