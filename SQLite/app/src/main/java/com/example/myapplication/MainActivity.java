package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button add, view;
    EditText name, age;
    Switch vip;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
        vip = findViewById(R.id.vip);
        list = findViewById(R.id.list);
    }

     public void addOnClick(View v) {
        CustomerModel customerModel = new CustomerModel(1, name.getText().toString(), Integer.parseInt(age.getText().toString()), vip.isChecked());
         Toast.makeText(this, customerModel.toString(), Toast.LENGTH_SHORT).show();

         DataBase db = new DataBase(MainActivity.this);
         boolean success = db.addOne(customerModel);
         Toast.makeText(this, "Success=" + success, Toast.LENGTH_SHORT).show();
     }

     public void viewOnClick(View v) {
         Toast.makeText(this, "Here the list", Toast.LENGTH_SHORT).show();

         DataBase db = new DataBase(MainActivity.this);
         List<CustomerModel> everyone = db.getEveryOne();
         ArrayAdapter<CustomerModel> arrayList = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
         list.setAdapter(arrayList);
     }
}