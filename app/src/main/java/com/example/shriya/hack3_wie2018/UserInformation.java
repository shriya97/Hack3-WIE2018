package com.example.shriya.hack3_wie2018;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by Shriya on 04-10-2018.
 */
@IgnoreExtraProperties
public class UserInformation
{
    public String name,address,email,phoneno,password;
    public UserInformation(){};

    public UserInformation(String email,String password) {
        this.email = email;
        this.password = password;
    }

}
