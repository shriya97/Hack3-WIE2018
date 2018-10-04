package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //    private DatabaseReference databaseReference;
    private EditText email,password;
    private Button loginButton;
    private String Email,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            email=(EditText) findViewById(R.id.email);
            password=(EditText) findViewById(R.id.Password);

            loginButton=(Button)findViewById(R.id.LoginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Email=email.getText().toString();
                    Password=password.getText().toString();
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    UserInformation user = new UserInformation(Email,Password);
                    String userId=Email.replace("@gmail.com","");
                    UserInformation.userId=userId;
                    rootRef.child(userId).child("userInformation").setValue(user);
                    Toast.makeText(MainActivity.this,"Logged In",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,CategoryActivity.class));
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    }
