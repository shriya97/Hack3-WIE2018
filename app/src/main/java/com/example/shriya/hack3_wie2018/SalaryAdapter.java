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
 * Created by diksha on 5/10/18.
 */

public class SalaryAdapter extends  RecyclerView.Adapter<SalaryAdapter.ViewHolder> {
    private List<Salary> mSalary;
    private Activity mActivity;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mEmployeeName;
        public TextView mSalary;
        public TextView mPendingAmount;
        public ImageButton fabButton;
        public ImageView mDelete;
        public ViewHolder(View v){
            super(v);
            mPendingAmount = (TextView)v.findViewById(R.id.pending_amount) ;
            fabButton = (ImageButton)v.findViewById(R.id.fab_image_button);
            mSalary = (TextView) v.findViewById(R.id.salary);
            mEmployeeName=(TextView) v.findViewById(R.id.employeeName);
            mDelete=(ImageView)v.findViewById(R.id.delete);
        }
    }
    public SalaryAdapter(List<Salary> salaries, Activity context){
        mSalary = salaries;
        mActivity = context;
    }
    @Override
    public SalaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.salary_item, parent, false);
        ViewHolder vh = new ViewHolder (v);
        return vh;
    };

    @Override
    public void onBindViewHolder(SalaryAdapter.ViewHolder holder, final int position)
    {
        final Salary salary = mSalary.get(position);
        holder.mEmployeeName.setText(salary.getEmployeeName());
        holder.mPendingAmount.setText(salary.getPendingAmount());
        holder.mSalary.setText(salary.getSalary());
        holder.mDelete.setVisibility(View.VISIBLE);
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSalary.remove(salary);
                notifyItemRemoved(position);
                //notify the db
            }
        });

    }
    @Override
    public int getItemCount() {
        return mSalary.size();
    }
}
