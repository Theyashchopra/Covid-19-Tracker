package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openStates(View view) {
        startActivity(new Intent(this,StatesActivity.class));
    }

    public void openZones(View view) {
       // startActivity(new Intent(this,ZonesActivity.class));
    }
}
