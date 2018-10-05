package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Priyanka on 10/5/2018.
 */

public class EarningActivity extends AppCompatActivity {
    public EarningActivity() {
        super();
    }
private String userId;
private ArrayList<Earning> earnings;
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


        earnings= new ArrayList<Earning>();
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
                            if (ds.hasChild("personalFinance")) {
                                for(DataSnapshot ds2:ds.child("personalFinance").child("earnings").getChildren())
                                {
                                    String productName=ds2.getKey().toString();
                                    String productData=ds2.getValue().toString();
                                    String data[]=productData.split(" ");
                                    earnings.add(new Earning(productName,data[0]));
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
            Toast.makeText(EarningActivity.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
//        earnings.add(new Earning("sdfsd","3"));
        RecyclerView list = (RecyclerView) findViewById(R.id.EarningList);
        EarningAdapter adapter = new EarningAdapter(earnings, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));

    }
}

