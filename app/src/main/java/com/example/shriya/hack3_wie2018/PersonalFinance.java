package com.example.shriya.hack3_wie2018;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Shriya on 04-10-2018.
 */
@IgnoreExtraProperties
public class PersonalFinance
{
    public String Expenses,Spending;

    public void PersonalFinance(){}

    public void PersonalFinance(String Expenses,String Spending){
        this.Expenses=Expenses;
        this.Spending=Spending;
    }
}
