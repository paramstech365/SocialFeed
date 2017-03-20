package com.katemayorenko.socialfeed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String>content = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);


        listView = (ListView)findViewById(R.id.listView); // news list

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,titles);

        listView.setAdapter(adapter);

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), WebContentActivity.class);
                intent.putExtra("content", content.get(i));

                startActivity(intent);
            }
        });*/


    }
}
