package com.example.shriya.hack3_wie2018;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Priyanka on 10/5/2018.
 */

public class expenditureAdapter extends RecyclerView.Adapter<expenditureAdapter.ViewHolder>{
    private List<expenditure> mExpenditure;
    private Activity mActivity;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mProductName;
        public TextView mPrice;
        public ImageButton fabButton;
        public ImageView mDelete;
        public ViewHolder(View v){
            super(v);
            mProductName = (TextView)v.findViewById(R.id.productName) ;
            fabButton = (ImageButton)v.findViewById(R.id.fab_image_button);
            mPrice = (TextView) v.findViewById(R.id.price);
            mDelete=(ImageView)v.findViewById(R.id.delete);
        }
    }
    public expenditureAdapter(List<expenditure> expenditures, Activity context){
        mExpenditure = expenditures;
        mActivity = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expenditure_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    };

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        final expenditure tempexpenditure = mExpenditure.get(position);
        holder.mProductName.setText(tempexpenditure.getProductName());
        holder.mPrice.setText(tempexpenditure.getPrice());
        holder.mDelete.setVisibility(View.VISIBLE);
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExpenditure.remove(tempexpenditure);
                notifyItemRemoved(position);
                //notify the db
            }
        });

    }
    @Override
    public int getItemCount() {
        return mExpenditure.size();
    }
}
