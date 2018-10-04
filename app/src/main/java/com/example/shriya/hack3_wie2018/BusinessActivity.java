package com.example.shriya.hack3_wie2018;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusinessActivity extends AppCompatActivity {

    private static final String TAG = "app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
//                int count = 0;
                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {
                    msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
//                    Log.i(TAG, "onCreate: " + msgData);


                    String amount = readAmount(msgData);

                }
//                Log.i(TAG, "onCreate: " + count);

                // use msgData
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }
        TextView salesView = findViewById(R.id.sales);
        TextView inventoryView = findViewById(R.id.inventory);
        TextView salaryView = findViewById(R.id.salary_a);

        salesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salesIntent = new Intent(BusinessActivity.this, CalendarActivity.class);
                startActivity(salesIntent);
            }
        });

        inventoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salesIntent = new Intent(BusinessActivity.this, InventoryActivity.class);
                startActivity(salesIntent);
            }
        });

        salaryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salaryIntent = new Intent(BusinessActivity.this, SalaryActivity.class);
                startActivity(salaryIntent);
            }
        });
    }

    private String readAmount(String msgData) {
//        Log.i(TAG, "readAmount: "+ msgData);
        String amount = "";
        if (msgData.contains("debited") || msgData.contains("debited")){
            Pattern regEx
                    = Pattern.compile("(?i)(?:(?:RS|INR|MRP)\\.?\\s?)(\\d+(:?\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)");
            Matcher m = regEx.matcher(msgData);
//            Log.i(TAG, "readAmount: " + m.find());
            Log.i(TAG, msgData);
            if (m.find()) {
                try {
//                    Log.e("amount_value= ", "" + m.group(0));
                    amount = (m.group(0).replaceAll("inr", ""));
                    amount = amount.replaceAll("rs", "");
                    amount = amount.replaceAll("inr", "");
                    amount = amount.replaceAll(" ", "");
                    amount = amount.replaceAll(",", "");
                    if (msgData.contains("debited") ||
                            msgData.contains("purchasing") || msgData.contains("purchase") || msgData.contains("dr")) {
                        Log.i(TAG, "readAmount: " + amount);
                    } else if (msgData.contains("credited") || msgData.contains("cr")) {
                        Log.i(TAG, "readAmount: " + amount + " credited");
                    }
//                    Log.e("matchedValue= ", "" + amount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return amount;
    }
}
