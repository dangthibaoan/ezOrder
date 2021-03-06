package com.example.ezorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.ezorder.Model.Role;
import com.example.ezorder.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "Database TAG";

    // TODO : Database info
    private static final String DATABASE_NAME = "OrderDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // TODO : Table User
    private static final String TABLE_USER               = "tblUser";
    private static final String COLUMN_USER_ID           = "User_ID";
    private static final String COLUMN_USER_NAME         = "User_Name";
    private static final String COLUMN_USER_PHONE        = "User_Phone";
    private static final String COLUMN_USER_ACCOUNT_NAME = "User_username";
    private static final String COLUMN_USER_ACCOUNT_PASS = "User_password";
    private static final String COLUMN_USER_STATUS       = "User_status";
    private static final String COLUMN_USER_ROLE_FK      = "Role_ID";

    // TODO : Table Role
    private static final String TABLE_ROLE       = "tblRole";
    private static final String COLUMN_ROLE_ID   = "Role_ID";
    private static final String COLUMN_ROLE_NAME = "Role_Name";

    // TODO : Table "Table"
    private static final String TABLE_TABLE         = "tblTable";
    private static final String COLUMN_TABLE_ID     = "Table_ID";
    private static final String COLUMN_TABLE_NUMBER = "Table_number";
    private static final String COLUMN_TABLE_STATUS = "Table_status";

    // TODO : Table Food
    private static final String TABLE_FOOD         = "tblFood";
    private static final String COLUMN_FOOD_ID     = "Food_ID";
    private static final String COLUMN_FOOD_NAME   = "Food_Name";
    private static final String COLUMN_FOOD_UNIT   = "Food_Unit";
    private static final String COLUMN_FOOD_PRICE  = "Food_Price";
    private static final String COLUMN_FOOD_IMAGE  = "Food_Image";
    private static final String COLUMN_FOOD_STATUS = "Food_Status";

    // TODO : Table Order
    private static final String TABLE_ORDER           = "tblOrder";
    private static final String COLUMN_ORDER_ID       = "Order_ID";
    private static final String COLUMN_ORDER_NUMBER   = "Order_Number";
    private static final String COLUMN_ORDER_TIME     = "Order_Time";
    private static final String COLUMN_ORDER_NOTE     = "Order_Note";
    private static final String COLUMN_ORDER_FOOD_FK  = "Food_ID";
    private static final String COLUMN_ORDER_TABLE_FK = "Table_ID";

    // TODO : Table Bill
    private static final String TABLE_BILL           = "tblBill";
    private static final String COLUMN_BILL_ID       = "Bill_ID";
    private static final String COLUMN_BILL_TOTAL    = "Bill_total";
    private static final String COLUMN_BILL_TIME     = "Bill_time";
    private static final String COLUMN_BILL_USER_FK  = "User_ID";
    private static final String COLUMN_BILL_ORDER_FK = "Order_ID";


    //TODO**: STRING CREATE TABLE

    // TODO : table User
    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + "( " +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_NAME + " TEXT," +
            COLUMN_USER_PHONE + " TEXT," +
            COLUMN_USER_ACCOUNT_NAME + " TEXT," +
            COLUMN_USER_ACCOUNT_PASS + " TEXT," +
            COLUMN_USER_STATUS + " INTEGER," +
            COLUMN_USER_ROLE_FK + " INTEGER REFERENCES " + TABLE_ROLE + "(" + COLUMN_ROLE_ID + ") ON DELETE SET NULL)";

    // TODO : table Role
    private static final String CREATE_TABLE_ROLE = "CREATE TABLE IF NOT EXISTS " + TABLE_ROLE + "( " +
            COLUMN_ROLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_ROLE_NAME + " TEXT )";

    // TODO : table Table
    private static final String CREATE_TABLE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_TABLE + "( " +
            COLUMN_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_TABLE_NUMBER + " INTEGER," +
            COLUMN_TABLE_STATUS + " INTEGER )";

    // TODO : table Food
    private static final String CREATE_TABLE_FOOD = "CREATE TABLE IF NOT EXISTS " + TABLE_FOOD + "( " +
            COLUMN_FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_FOOD_NAME + " TEXT," +
            COLUMN_FOOD_PRICE + " INTEGER," +
            COLUMN_FOOD_IMAGE + " BLOB," +
            COLUMN_FOOD_UNIT + " TEXT," +
            COLUMN_FOOD_STATUS + " INTEGER )";

    // TODO : table Order
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE IF NOT EXISTS " + TABLE_ORDER + "( " +
            COLUMN_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_ORDER_NUMBER + " INTEGER," +
            COLUMN_ORDER_TIME + " TEXT," +
            COLUMN_ORDER_NOTE + " TEXT," +
            COLUMN_ORDER_FOOD_FK + " INTEGER REFERENCES " + TABLE_FOOD + "(" + COLUMN_FOOD_ID + ") ON DELETE SET NULL," +
            COLUMN_ORDER_TABLE_FK + " INTEGER REFERENCES " + TABLE_TABLE + "(" + COLUMN_TABLE_ID + ") ON DELETE SET NULL)";

    // TODO : table Bill
    private static final String CREATE_TABLE_BILL = "CREATE TABLE IF NOT EXISTS " + TABLE_BILL + "( " +
            COLUMN_BILL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_BILL_TIME +  " TEXT," +
            COLUMN_BILL_TOTAL + " INTEGER," +
            COLUMN_BILL_USER_FK + " INTEGER REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ") ON DELETE SET NULL," +
            COLUMN_BILL_ORDER_FK + " INTEGER REFERENCES " + TABLE_ORDER + "(" + COLUMN_ORDER_ID + ") ON DELETE SET NULL)";


    // TODO : STRING DROP
    private static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS " + TABLE_USER;
    private static final String DROP_TABLE_ROLE = "DROP TABLE IF EXISTS " + TABLE_ROLE;
    private static final String DROP_TABLE_TABLE = "DROP TABLE IF EXISTS " + TABLE_TABLE;
    private static final String DROP_TABLE_FOOD = "DROP TABLE IF EXISTS " + TABLE_FOOD;
    private static final String DROP_TABLE_ORDER = "DROP TABLE IF EXISTS " + TABLE_ORDER;
    private static final String DROP_TABLE_BILL = "DROP TABLE IF EXISTS " + TABLE_BILL;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ROLE);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_TABLE);
        db.execSQL(CREATE_TABLE_FOOD);
        db.execSQL(CREATE_TABLE_ORDER);
        db.execSQL(CREATE_TABLE_BILL);

//        Role role = new Role();
//        for (int i=0;i<3;i++){
//            role.setRoleID(i);
//            if (i==0) role.setRoleName("ADMIN");
//            else if (i==1) role.setRoleName("ORDER");
//            else role.setRoleName("CHEF");
//
//            ContentValues contentValues = new ContentValues();
//            contentValues.put(COLUMN_ROLE_NAME,role.getRoleName());
//
//            db.insert(TABLE_ROLE,null,contentValues);
//        }
//        insertAdmin(db);
        db.close();
        Log.d(TAG, "onCreate: Running ...!");
    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }

    public void insertAdmin(SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME,"");
        contentValues.put(COLUMN_USER_PHONE,"");
        contentValues.put(COLUMN_USER_ACCOUNT_NAME,"admin");
        contentValues.put(COLUMN_USER_ACCOUNT_PASS,"123456");
        contentValues.put(COLUMN_USER_STATUS,0); //0 - Bình thường; 1 - Cấm đăng nhập
        contentValues.put(COLUMN_USER_ROLE_FK,getRoleID("ADMIN"));

        db.insert(TABLE_USER,null,contentValues);
    }
    //Lấy roleID theo roleName đã biết
    public int getRoleID(String roleName){
        List<Role> roleID = new ArrayList<Role>();
        String sql = "SELECT * FROM " + TABLE_ROLE
                + " WHERE " + COLUMN_ROLE_NAME + " LIKE '%" + roleName + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql, null);

        c.close();
        db.close();
        return roleID.get(0).getRoleID();
    }

    public int getUserRoleID(String Username, String Password){
        List<User> userRoleID = new ArrayList<User>();
        String sql = "SELECT * FROM " + TABLE_USER
                + " WHERE " + COLUMN_USER_ACCOUNT_NAME + " = '" + Username + "' AND "
                + COLUMN_USER_ACCOUNT_PASS + " = '" + Password + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql, null);

        c.close();
        db.close();
        return userRoleID.get(0).getUser_role();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_BILL);
        db.execSQL(DROP_TABLE_ORDER);
        db.execSQL(DROP_TABLE_USER);
        db.execSQL(DROP_TABLE_ROLE);
        db.execSQL(DROP_TABLE_TABLE);
        db.execSQL(DROP_TABLE_FOOD);
        onCreate(db);

        Log.d(TAG, "onUpgrade: Running ...");
    }


}
