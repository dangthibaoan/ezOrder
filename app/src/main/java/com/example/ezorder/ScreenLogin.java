package com.example.ezorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ezorder.DBHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScreenLogin extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    //SQLiteDatabase db;
    EditText txtUsername;
    EditText txtPassword;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_login);

        txtUsername = findViewById(R.id.txtUsn);
        txtPassword = findViewById(R.id.txtPwd);

//        db = openOrCreateDatabase("ezOrderDB", MODE_PRIVATE, null);
//        final DBHelper dbHelper = new DBHelper(getApplicationContext());
//        final int admin = dbHelper.getRoleID("ADMIN");
//        final int order = dbHelper.getRoleID("ORDER");
//        final int chef = dbHelper.getRoleID("CHEF");

        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("user");
        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("ezOrder");

        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");
                String appTitle = dataSnapshot.getValue(String.class);
                // update toolbar title
                getSupportActionBar().setTitle(appTitle);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });


        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                //int roleID = dbHelper.getUserRoleID(username,password);

                //Demo chuyển activity, sẽ kết nối sqlite/firebase sau
//                if (){//roleID==admin
//                    startActivity(new Intent(ScreenLogin.this,ScreenAdmin.class));
//                }
//                else if (){//roleID==order
//                    startActivity(new Intent(ScreenLogin.this, ScreenTable.class));
//                }
//                else if (){//roleID==chef
//                    startActivity(new Intent(ScreenLogin.this,ScreenCook.class));
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),"Thông tin đăng nhập không đúng",Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}