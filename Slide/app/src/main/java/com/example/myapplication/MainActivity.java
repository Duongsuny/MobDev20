package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        feedbackBox = findViewById(R.id.feedback);
    }

    public void onClick(View v) {
        sendMessage();
    }
    public void sendMessage() {
        String fullName = input.getText().toString();
        String message = "Hello, say hi to me!";

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message" , message);

        this.startActivityForResult(intent, code);
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