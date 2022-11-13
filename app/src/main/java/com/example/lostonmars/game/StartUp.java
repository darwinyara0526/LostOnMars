package com.example.lostonmars.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lostonmars.R;
import com.example.lostonmars.game.GameMap1;

public class StartUp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
    }
    public void startGame(View View){
        startActivity(new Intent(this, GameMap1.class));
        finish();
    }
}
