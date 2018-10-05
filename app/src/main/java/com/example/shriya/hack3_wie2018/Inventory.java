package com.example.shriya.hack3_wie2018;

/**
 * Created by Priyanka on 10/4/2018.
 */

public class Inventory {
    String mproductName;
    String mqty;
    String mlocation;
    String mprice;
    public Inventory(String productName,String qty,String location,String price)
    {
        mproductName=productName;
        mqty=qty;
        mlocation=location;
        mprice=price;
    }
    public String getProductName(){
        return mproductName;
    }
    public String getqty(){
        return mqty;
    }
    public String getPrice() { return mprice; }
    public String getLocation(){
        return mlocation;
    }

}
