package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationClient;

    protected void onCreate(Bundle savedInstanceState) {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }
          mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {

        public void onSuccess(Location location) {
            if (location != null) {

            }
        }

    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}