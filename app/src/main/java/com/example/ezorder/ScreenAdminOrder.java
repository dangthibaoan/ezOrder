package com.example.ezorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScreenAdminOrder extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_admin_order);

        lv= (ListView) findViewById(R.id.list_item);
        list = new ArrayList<>();
        list.add("15");
        list.add("20");
        list.add("100");
        list.add("66");

        ArrayAdapter adt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        lv.setAdapter(adt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Demo, sửa sau
                startActivity(new Intent(ScreenAdminOrder.this,ScreenAdminOrderInfo.class));
            }
        });
    }
}