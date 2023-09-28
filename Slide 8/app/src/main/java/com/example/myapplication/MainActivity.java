package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Received", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//        intent.putExtra(SearchManager.QUERY, "Dai hoc Cong nghe");
//        startActivity(intent);

        IntentFilter intentFilter = new IntentFilter("android.intent.action.MY_ACTION");
        MyReceiver myReceiver = new MyReceiver();
        registerReceiver(myReceiver, intentFilter);
    }

    public void onSendBroadcast(View view) {
        Intent intent = new Intent("android.intent.action.MY_ACTION");
        sendBroadcast(intent);
    }
}