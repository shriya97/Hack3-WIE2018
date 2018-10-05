package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SalesActivity extends AppCompatActivity {

    private EditText productName,price,qty;
    private Button saveDetails;
    private String date,userId,sales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        Intent incoming = getIntent();
        date = incoming.getStringExtra("date");
        productName = findViewById(R.id.name_business);
        price = findViewById(R.id.price);
        qty = findViewById(R.id.product_qty);
        saveDetails = findViewById(R.id.add_details_button_business);
        userId = UserInformation.userId;
        try
        {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String id = ds.getKey();
                    if (userId.equals(id)) {
                        if (ds.hasChild("businessFinance")) {
                            if (ds.child("businessFinance").child("sales").hasChild(date)) {
                                sales = ds.child("businessFinance").child("sales").child(date).getValue().toString();
                                Toast.makeText(SalesActivity.this, sales, Toast.LENGTH_LONG).show();

                                String data2[] = sales.split(" ");

                                Toast.makeText(SalesActivity.this, sales, Toast.LENGTH_LONG).show();

                                productName.setText(data2[2]);
                                qty.setText(data2[5]);
                                price.setText(data2[7]);
                            }
                        } else
                            sales = "";
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
            Toast.makeText(SalesActivity.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
        saveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = price.getText().toString();
                String salesDataDisplay = "Sales of " + productName.getText().toString() + " with qty " + qty.getText().toString() + " is " + amount;
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child(userId).child("businessFinance").child("sales").child(date).setValue(salesDataDisplay);
            }
        });

    }
}
