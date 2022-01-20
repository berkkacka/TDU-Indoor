package com.brk.tduindoor;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {
private Button button_mensa;
private Button button_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        button_maps = (Button) findViewById(R.id.button_navigation);
        button_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNav();
            }
        });

        button_mensa = (Button) findViewById(R.id.button_mensa);
        button_mensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMensaList();
            }
        });

        Button button_bus = (Button) findViewById(R.id.button_bus);
        button_bus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openBusList();}
        });

        Button button_calendar = (Button) findViewById(R.id.calendar_btn);
        button_calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {openCalendarList();}
        });


    }
    public void openMensaList() {
        Intent intent = new Intent(this,MensaActivity.class);
        startActivity(intent);
    }
    public void openCalendarList() {
        Intent intent = new Intent(this,CalendarActivity.class);
        startActivity(intent);
    }
    public void openBusList() {
        Intent intent = new Intent(this, BusTabActivity.class);
        startActivity(intent);
    }

/*    public void openMaps(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }*/

    public void openNav() {
        Intent intent = new Intent(this,NavActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_info:
            displayInfo("TDU Navigation App für TDBB-Gebäude");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void displayInfo(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}