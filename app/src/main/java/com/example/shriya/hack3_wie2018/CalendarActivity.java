package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CalendarActivity extends AppCompatActivity {

    private  static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;
    private TextView displayText;
    private String userId,sales,date;
    private int totalsales,mon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        displayText = findViewById(R.id.total);
        totalsales = 0;
        try {

            mCalendarView = (CalendarView) findViewById(R.id.calendarView);
            userId = UserInformation.userId;
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();


                    displayText.setText("Total sales done is " + totalsales);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String id = ds.getKey();
                        if (userId.equals(id)) {
                            if (ds.hasChild("businessFinance")) {

                                for (int i = 1; i <= 31; i++) {
                                    String newdate = "2018-" + mon + "-" + i;
                                    if (ds.child("businessFinance").child("sales").hasChild(newdate)) {
                                        sales = ds.child("businessFinance").child("sales").child(newdate).getValue().toString();
//                            Toast.makeText(SalesActivity.this, sales, Toast.LENGTH_LONG).show();
//                                            String data = sales.replace("Sales for ", "");
                                        String data2[] = sales.split(" ");

//                                            Toast.makeText(CalendarActivity.this, sales, Toast.LENGTH_LONG).show();


                                        totalsales += Integer.parseInt(data2[7]);
                                    }
                                }
                                    }
                        }
                    }
                    displayText.setText("Total sales done is " + totalsales);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                    date = year + "-" + month + "-" + dayOfMonth;
                    mon=month;
                    Log.d(TAG, "onSelectedDayChange: yyyy-mm-dd:" + date);
                    Intent intent = new Intent(CalendarActivity.this, SalesActivity.class);
                    intent.putExtra("date", date);
                    startActivity(intent);
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(CalendarActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
