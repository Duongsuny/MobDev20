package com.example.slide11;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class SoundService extends Service {
    MediaPlayer player;
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service created", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(this, R.raw.fur_elise);
        player.setLooping(false);
    }

    public int onStartCommand(Intent intent,int flags, int startID) {
        Toast.makeText(this, "Sound played", Toast.LENGTH_LONG).show();
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Sound stopped", Toast.LENGTH_LONG).show();
        player.stop();
        player.release();
        player = null;
        super.onDestroy();
    }
}
