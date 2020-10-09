package com.example.ezorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScreenAdminTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_admin_table);

        Button btnAddTable = findViewById(R.id.btnAddTable);
        btnAddTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenAdminTable.this, ScreenAdminTableInfo.class));
            }
        });

        //sự kiện hiển thị list bàn ăn từ database sqlite

        //sự kiện click vào 1 item trong list bàn ăn
        
    }
}