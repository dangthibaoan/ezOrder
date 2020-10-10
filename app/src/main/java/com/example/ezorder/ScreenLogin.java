package com.example.ezorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ezorder.DBHelper;

public class ScreenLogin extends AppCompatActivity {

    SQLiteDatabase db;
    EditText txtUsername;
    EditText txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_login);

        txtUsername = findViewById(R.id.txtUsn);
        txtPassword = findViewById(R.id.txtPwd);

        db = openOrCreateDatabase("ezOrderDB", MODE_PRIVATE, null);
        final DBHelper dbHelper = new DBHelper(getApplicationContext());
        final int admin = dbHelper.getRoleID("ADMIN");
        final int order = dbHelper.getRoleID("ORDER");
        final int chef = dbHelper.getRoleID("CHEF");

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                int roleID = dbHelper.getUserRoleID(username,password);

                //Demo chuyển activity, sẽ kết nối sqlite sau
                if (roleID==admin){
                    startActivity(new Intent(ScreenLogin.this,ScreenAdmin.class));
                }
                else if (roleID==order){
                    startActivity(new Intent(ScreenLogin.this, ScreenTable.class));
                }
                else if (roleID==chef){
                    startActivity(new Intent(ScreenLogin.this,ScreenCook.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Thông tin đăng nhập không đúng",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}