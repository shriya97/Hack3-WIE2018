package com.example.shriya.hack3_wie2018;

/**
 * Created by Priyanka on 10/4/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;

public class CategoryActivity extends AppCompatActivity {


    private static final String TAG = "CategoryActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Button business = findViewById(R.id.business);
        Button personal = findViewById(R.id.personal);
        Button chat = findViewById(R.id.chat);


        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent (getBaseContext(), BusinessActivity.class);
                startActivity(intent);
            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent (getBaseContext(), PersonalActivity.class);
                startActivity(intent);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent (getBaseContext(), NGOChatActivity.class);
                startActivity(intent);
            }
        });
    }

}