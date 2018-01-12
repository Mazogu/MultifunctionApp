package com.example.micha.camerapersoninterest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPhotoActivity(View view) {
       Intent intent = new Intent(getApplicationContext(),CameraActivity.class);
       startActivity(intent);
    }

    public void EMIActivity(View view) {
       Intent intent = new Intent(getApplicationContext(),EMIActivity.class);
       startActivity(intent);
    }

    public void PersonListActivity(View view) {
        Intent intent = new Intent(getApplicationContext(),PersonActivity.class);
        startActivity(intent);
    }
}
