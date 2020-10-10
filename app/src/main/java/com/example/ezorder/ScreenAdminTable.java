package com.example.ezorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScreenAdminTable extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_admin_table);

        lv= (ListView) findViewById(R.id.list_item);
        list = new ArrayList<>();
        list.add("Bàn 1");
        list.add("Bàn 2");
        list.add("Bàn 3");
        list.add("Bàn 4");

        ArrayAdapter adt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        lv.setAdapter(adt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Demo
                startActivity(new Intent(ScreenAdminTable.this,ScreenAdminTableInfo.class));
            }
        });
    }

    public void onClick(android.view.View View){
        //Demo
        startActivity(new Intent(ScreenAdminTable.this,ScreenAdminTableInfo.class));
    }
}