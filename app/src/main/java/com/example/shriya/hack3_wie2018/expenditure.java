package com.example.shriya.hack3_wie2018;

/**
 * Created by Priyanka on 10/5/2018.
 */

public class expenditure{
    String productName;
    String price;
    public expenditure(String productName,String price)
    {
        this.productName=productName;
        this.price=price;
    }
    public String getProductName()
    {
        return productName;
    }
    public String getPrice()
    {
        return price;
    }
}
