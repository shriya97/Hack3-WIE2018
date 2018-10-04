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

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {


    public InventoryActivity(){
        super();
    }





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


        ArrayList<Inventory> inventories= new ArrayList<Inventory>();
        inventories.add(new Inventory("sdfsd","3","safs","300"));
        RecyclerView list = (RecyclerView) findViewById(R.id.inventoryList);
        InventoryAdapter adapter = new InventoryAdapter(inventories, this);
        list.setAdapter(adapter);
        list.setLayoutManager((new LinearLayoutManager(this)));

    }

}
