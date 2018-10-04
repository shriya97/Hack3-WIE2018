package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {


    public InventoryActivity(){
        super();
    }

private String userId,date,sales;
    private   ArrayList<Inventory> inventories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inventory);

        android.support.design.widget.FloatingActionButton   fab = findViewById(R.id.fab_image_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), inventory_form.class);
                startActivity(intent);
            }
        });


        inventories= new ArrayList<Inventory>();
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
                                for(DataSnapshot ds2:ds.child("businessFinance").child("inventory").getChildren())
                                {
                                    String productName=ds2.getKey().toString();
                                    String productData=ds2.getValue().toString();
                                    String data[]=productData.split(" ");
                                    inventories.add(new Inventory(productName,data[0],data[1],data[2]));
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
            Toast.makeText(InventoryActivity.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

        RecyclerView list = (RecyclerView) findViewById(R.id.inventoryList);
        InventoryAdapter adapter = new InventoryAdapter(inventories, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));

    }

}
