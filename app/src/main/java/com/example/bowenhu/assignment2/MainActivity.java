package com.example.bowenhu.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> data_name = new ArrayList<String>();
    public static ArrayList<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
    public SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String data = intent.getStringExtra("SystolicPressure") + "/" + intent.getStringExtra("SystolicPressure") + "  " + intent.getStringExtra("HeartRate");
        String time = "    " + intent.getStringExtra("Date") + " " + intent.getStringExtra("time") + "\n";
        String comment = intent.getStringExtra("comment");

        String show = data + time + comment;

        System.out.println("show");
        System.out.println(show);

        if(intent.getStringExtra("Date") != null) {
            data_name.add(show);
        }

        for (int i = 0; i < data_name.size(); i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", data_name.get(i));
            listitem.add(map);
        }



        adapter=new SimpleAdapter(this,listitem,R.layout.main,new String[]{"data"},new int[]{R.id.data});
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);



        Button login=(Button)findViewById(R.id.btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
//                System.out.println("test");

            }
        });




    }
}
