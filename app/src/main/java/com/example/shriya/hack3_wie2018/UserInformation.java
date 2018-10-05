package com.example.shriya.hack3_wie2018;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by Shriya on 04-10-2018.
 */
@IgnoreExtraProperties
public class UserInformation
{
    public static String userId;
    public String name,address,email,phoneno,password,type;
    public UserInformation(){};

    public UserInformation(String email,String password,String type) {
        this.email = email;
        this.password = password;
        this.type=type;
    }

}
