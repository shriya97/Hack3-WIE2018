package com.example.shriya.hack3_wie2018;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class NGOChatActivity extends AppCompatActivity {
    ListView usersList;
    TextView noUsersText;
    ArrayList<String> al = new ArrayList<>();
    int totalUsers = 0;
    ProgressDialog pd;
    Firebase reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngochat);

        usersList = (ListView) findViewById(R.id.usersList);
        noUsersText = (TextView) findViewById(R.id.noUsersText);

        pd = new ProgressDialog(NGOChatActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        String url = "https://demofirebase-1234.firebaseio.com/users.json";


        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                doOnSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(NGOChatActivity.this);
        rQueue.add(request);

        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserDetailsChat.chatWith = al.get(position);
                startActivity(new Intent(NGOChatActivity.this, ChatActivity.class));
            }
        });
    }
    public void doOnSuccess(String s){
        try {
            JSONObject obj = new JSONObject(s);

            Iterator i = obj.keys();
            String key = "";

            while(i.hasNext()){
                key = i.next().toString();
                String data[]=key.split("_");
                if(!data[0].equals(UserDetailsChat.username)) {
                    al.add(data[0]);
                }

                totalUsers++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        try {
//            JSONObject obj = new JSONObject(s);
//
//            Iterator i = obj.keys();
//            String key = "";
//
//            while(i.hasNext()){
//                key = i.next().toString();
//
//                if(!key.equals(UserDetails.username))
//                {
//                    String users[]=key.split("_");
//                    Intent intent=getIntent();
//                    String loginUser= intent.getExtras().get("user").toString();
//                    if(!al.contains(users[0])&&(!users[0].equals(loginUser)))
//                        al.add(users[0]);
//                }
//
//                totalUsers++;
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        if(totalUsers <=1){
            noUsersText.setVisibility(View.VISIBLE);
            usersList.setVisibility(View.GONE);
        }
        else{
            noUsersText.setVisibility(View.GONE);
            usersList.setVisibility(View.VISIBLE);
            usersList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al));
        }

        pd.dismiss();
    }
}
