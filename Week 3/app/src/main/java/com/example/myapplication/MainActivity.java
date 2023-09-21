package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button popupButton;
    Button anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) this.findViewById(R.id.contextbutton);
        this.registerForContextMenu(button);

        popupButton = (Button) this.findViewById(R.id.popupbutton);
        anchor = (Button) findViewById(R.id.anchor);

        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick();
            }
        });

    }


    private void handleClick() {

        PopupMenu popup = new PopupMenu(this, anchor);
        popup.inflate(R.menu.popup_menu);

        Menu menu = popup.getMenu();


        popup.setOnMenuItemClickListener(item -> menuItemClicked(item));

        popup.show();
    }

    private boolean menuItemClicked(MenuItem item) {
        int itemId = item.getItemId(); // Get the ID once to avoid redundant method calls

        if (itemId == R.id.opt1) {
            Toast.makeText(this, "Upload", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt2) {
            Toast.makeText(this, "Download", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt3) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Context menu");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_context_menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        MenuInflater menuItem = (MenuInflater) menu.findItem(R.id.item1);
        return super.onCreateOptionsMenu(menu);
    }
}
