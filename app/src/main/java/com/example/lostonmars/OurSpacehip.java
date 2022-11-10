package com.example.lostonmars;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class OurSpacehip {
    Context context;
    Bitmap ourSpaceship;
    int ox, oy;
    Random random;

    public OurSpacehip(Context context) {
        this.context = context;
        ourSpaceship = BitmapFactory.decodeResource(context.getResources(), R.drawable.rocket1);
        random = new Random();
        ox = random.nextInt(SpaceShooter.screenWidth);
        oy = SpaceShooter.screenHeight - ourSpaceship.getHeight();
    }

    public Bitmap getOurSpaceship(){
        return ourSpaceship;
    }

    int getOurSpaceshipWidth(){
        return ourSpaceship.getWidth();
    }

}
