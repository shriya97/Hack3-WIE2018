package com.example.shriya.hack3_wie2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        try {
//            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//            UserInformation user = new UserInformation("bb", "aa", "a", "a", "a");
//            rootRef.child("new").setValue(user);
//            DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
//            DatabaseReference demoRef = databaseReference.child("demo");
//                    String value = "aa";
//                    //push creates a unique id in database
//                    demoRef.setValue(value);
//            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    int f = 0;
//                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                        Toast.makeText(MainActivity.this,ds.getKey(),Toast.LENGTH_LONG).show();
//                    }
//                }
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                }
//
//            });
//
//        }
//        catch (Exception e)
//        {
//            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
//        }
//    }
    }
}