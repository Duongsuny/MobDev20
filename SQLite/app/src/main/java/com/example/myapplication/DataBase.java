package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    public static final String VIP = "VIP";
    public static final String CUSTOMER = "CUSTOMER";

    public DataBase(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + CUSTOMER + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + AGE + " INTEGER, " + VIP + " BOOL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(CustomerModel customerModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME, customerModel.getName());
        cv.put(AGE, customerModel.getAge());
        cv.put(VIP, customerModel.isVip());

        long insert = db.insert(CUSTOMER, null,cv);

        return insert != -1;
    }

    public List<CustomerModel> getEveryOne() {
        List<CustomerModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CUSTOMER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                int customerAge = cursor.getInt(2);
                boolean customerVip = (cursor.getInt(3) == 1);

                CustomerModel customerModel = new CustomerModel(customerID, customerName, customerAge, customerVip);
                returnList.add(customerModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return returnList;
    }
}
