package com.example.gabri.tugasbesar2;

import android.util.Log;

import java.util.Random;

public class BolaMoveable implements Lingkaran {

    protected Random rand;
    protected float x;
    protected float y;


    public float getX() {
        return x;
    }

    public float getRad(){
        return Lingkaran.radius;
    }


    public float getY() {
        return y;
    }

    @Override
    public void posistion(int height, int width) {
        rand = new Random();
        this.x = rand.nextInt(width);
        this.y = rand.nextInt(height);
    }

    public void move(float newX, float newY){
        this.x = this.x + newX;
        this.y = this.y + newY;
    }




}
