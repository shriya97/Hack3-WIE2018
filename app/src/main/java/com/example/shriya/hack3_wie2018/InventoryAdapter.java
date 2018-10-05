package com.example.shriya.hack3_wie2018;

/**
 * Created by Priyanka on 10/4/2018.
 */


import android.app.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



import org.json.JSONException;
import org.json.JSONObject;

import java.net.Socket;
import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {
    private List<Inventory> mInventory;
    private Activity mActivity;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mProductName;
        public TextView mPrice;
        public TextView mLocation;
        public TextView mQty;
        public ImageButton fabButton;
        public ImageView mDelete;
        public ViewHolder(View v){
            super(v);
            mProductName = (TextView)v.findViewById(R.id.productName) ;
            fabButton = (ImageButton)v.findViewById(R.id.fab_image_button);
            mPrice = (TextView) v.findViewById(R.id.price);
            mLocation=(TextView) v.findViewById(R.id.location);
            mQty=(TextView) v.findViewById(R.id.product_qty);
            mDelete=(ImageView)v.findViewById(R.id.delete);
        }
    }
    public InventoryAdapter(List<Inventory> inventories, Activity context){
        mInventory = inventories;
        mActivity = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_obj, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    };

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        final Inventory inventory = mInventory.get(position);
        holder.mProductName.setText(inventory.getProductName());
        holder.mQty.setText(inventory.getqty());
        holder.mQty.setText(inventory.getLocation());
        holder.mPrice.setText(inventory.getPrice());
        holder.mDelete.setVisibility(View.VISIBLE);
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInventory.remove(inventory);
                notifyItemRemoved(position);
                //notify the db
            }
        });

    }
    @Override
    public int getItemCount() {
        return mInventory.size();
    }


}
