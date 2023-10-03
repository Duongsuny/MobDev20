package com.example.slide11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
    }

    public void playMusic(View v) {
        startService(new Intent(this, SoundService.class));
    }

    public void stopMusic(View v) {
        stopService(new Intent(this, SoundService.class));
    }
}