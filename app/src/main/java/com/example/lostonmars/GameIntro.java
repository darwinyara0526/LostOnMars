package com.example.lostonmars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class GameIntro extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_intro);

    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Intent intent = new Intent(GameIntro.this, GameMap1.class);
            startActivity(intent);
            finish();
        }
    },5000);
    }
}