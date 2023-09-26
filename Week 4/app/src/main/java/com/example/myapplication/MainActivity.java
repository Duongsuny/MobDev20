package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = this.findViewById(R.id.contextButton);
        this.registerForContextMenu(button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Bài tập tuần 4");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.ex1) {
            setContentView(R.layout.exercise2);
        } else if (itemId == R.id.ex2) {
            setContentView(R.layout.relative_layout);
        }
        return true;
    }


    public void onExit(View view) {
        recreate();
        setContentView(R.layout.activity_main);
    }

}

