package com.example.shriya.hack3_wie2018;

/**
 * Created by Priyanka on 10/5/2018.
 */

import android.widget.ImageView;

import java.util.List;

        import android.app.Activity;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import static com.example.shriya.hack3_wie2018.UserInformation.userId;

/**
 * Created by Priyanka on 10/5/2018.
 */

public class EarningAdapter extends RecyclerView.Adapter<EarningAdapter.ViewHolder>{
    private List<Earning> mEarning;
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
    public EarningAdapter(List<Earning> earnings, Activity context){
        mEarning = earnings;
        mActivity = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.earning_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    };

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        final Earning earning = mEarning.get(position);
        holder.mProductName.setText(earning.getProductName());
        holder.mPrice.setText(earning.getPrice());
        holder.mDelete.setVisibility(View.VISIBLE);
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEarning.remove(earning);
                notifyItemRemoved(position);
                //notify the db
                FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("personalFinance").child("earnings").child(earning.getProductName()).removeValue();

            }
        });

    }
    @Override
    public int getItemCount() {
        return mEarning.size();
    }
}
