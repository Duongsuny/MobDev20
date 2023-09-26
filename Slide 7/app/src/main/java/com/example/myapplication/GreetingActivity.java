package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class GreetingActivity extends AppCompatActivity {

    TextView message;
    String fullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        message = findViewById(R.id.mes);
        Intent intent = this.getIntent();
        fullName = intent.getStringExtra("fullName");
        message.setText(intent.getStringExtra("message"));
    }

    public void onBack(View view) {
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "Hello " + fullName + ", I hate android studio";
        data.putExtra("feedback", feedback);

        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}