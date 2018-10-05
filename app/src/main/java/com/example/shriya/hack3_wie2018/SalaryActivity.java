package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SalaryActivity extends AppCompatActivity {

    private String userId;
    private ArrayList<Salary> salaries;
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


        salaries= new ArrayList<Salary>();
        userId = UserInformation.userId;
        try
        {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String id = ds.getKey();
                        if (userId.equals(id)) {
                            if (ds.hasChild("businessFinance")) {
                                for(DataSnapshot ds2:ds.child("businessFinance").child("salaries").getChildren())
                                {
                                    String productName=ds2.getKey().toString();
                                    String productData=ds2.getValue().toString();
                                    String data[]=productData.split(" ");
                                    salaries.add(new Salary(productName,data[0],data[1]));
                                }
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        catch(Exception e)
        {
            Toast.makeText(SalaryActivity.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
        RecyclerView list = (RecyclerView) findViewById(R.id.salaryList);
        SalaryAdapter adapter = new SalaryAdapter(salaries, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));
    }
}
