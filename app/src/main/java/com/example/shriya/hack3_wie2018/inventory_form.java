package com.example.shriya.hack3_wie2018;

/**
 * Created by Priyanka on 10/4/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class inventory_form extends AppCompatActivity {


    EditText ed1, ed2,ed3,ed4;
    Button b1;

    private static final String TAG = "business_form";
    private static  final int BUSINESS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_form);

        ed1 = (EditText) findViewById(R.id.name_business);
        ed2 = (EditText) findViewById(R.id.product_qty);
        ed3 = (EditText) findViewById(R.id.location);
        ed4 = (EditText) findViewById(R.id.price);
        b1 = (Button) findViewById(R.id.add_details_button_business);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String name = ed1.getText().toString().trim();
                String email = ed2.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    ed1.setError("Invalid");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    ed2.setError("Invalid");
                    return;
                }


                Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(inventory_form.this, MainActivity.class));
                finish();

            }
        });

    }

}