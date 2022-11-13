package com.example.lostonmars.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameMap1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SpaceShooter(this));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}