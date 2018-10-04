package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Salary_formActivity extends AppCompatActivity {

    EditText ed1, ed2,ed3,ed4;
    Button b1;

    private static final String TAG = "business_form";
    private static  final int BUSINESS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_form);

        ed1 = (EditText) findViewById(R.id.employee_name);
        ed2 = (EditText) findViewById(R.id.salary);
        ed3 = (EditText) findViewById(R.id.pending);
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
                startActivity(new Intent(Salary_formActivity.this, SalaryActivity.class));
                finish();

            }
        });

    }
}
