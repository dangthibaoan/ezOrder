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

public class ScreenAdmin extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_admin);

        lv= (ListView) findViewById(R.id.list_item);
        list = new ArrayList<>();
        list.add("Bàn ăn");
        list.add("Món ăn");
        list.add("Order");
        list.add("Tài khoản");

        ArrayAdapter adt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        lv.setAdapter(adt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (list.get(i).equals("Bàn ăn")){
                    startActivity(new Intent(ScreenAdmin.this,ScreenAdminTable.class));
                }
                else if (list.get(i).equals("Món ăn")){
                    startActivity(new Intent(ScreenAdmin.this,ScreenAdminFood.class));
                }
                else if (list.get(i).equals("Order")){
                    startActivity(new Intent(ScreenAdmin.this,ScreenAdminOrder.class));
                }
                else if (list.get(i).equals("Tài khoản")){
                    startActivity(new Intent(ScreenAdmin.this,ScreenAdminAccount.class));
                }
            }
        });
    }
}