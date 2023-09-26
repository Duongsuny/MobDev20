package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.EditText;


import androidx.annotation.Nullable;

import android.view.View;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    int code = 1211;
    TextView feedbackBox;
    ComponentName componentName = new ComponentName(this, GreetingActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        feedbackBox = findViewById(R.id.feedback);

        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.ACTION_MY_EVENT");
        registerReceiver(receiver, intentFilter);
    }

    public void onClick(View v) {
        sendMessage();
    }
    public void sendMessage() {
        String fullName = input.getText().toString();
        String message = "Hello, say hi to me!";

        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message" , message);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == code){
            assert data != null;
            String feedback = data.getStringExtra("feedback");
            feedbackBox.setText(feedback);
        } else {
            feedbackBox.setText("???");
        }
    }


}