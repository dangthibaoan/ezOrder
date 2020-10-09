package com.example.ezorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScreenLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_login);

        final EditText txtUsername = findViewById(R.id.txtUsn);
        final EditText txtPassword = findViewById(R.id.txtPwd);

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                //Demo chuyển activity, sẽ kết nối sqlite sau
                if (username.equals("admin") & !password.equals("")){
                    startActivity(new Intent(ScreenLogin.this,ScreenAdmin.class));
                }
                else if (username.equals("order") & !password.equals("")){
                    startActivity(new Intent(ScreenLogin.this, ScreenTable.class));
                }
                else if (username.equals("cook") & !password.equals("")){
                    startActivity(new Intent(ScreenLogin.this,ScreenCook.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Thông tin đăng nhập không đúng",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}