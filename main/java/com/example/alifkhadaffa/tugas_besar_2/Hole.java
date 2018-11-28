package com.example.alifkhadaffa.tugas_besar_2;

import java.util.Random;

public class Hole implements Lingkaran {

    protected float x;
    protected float y;
    protected Random rand;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRad(){
        return Lingkaran.radius;
    }


    @Override
    public void posistion(int height, int width) {
        this.rand = new Random();
        this.x = rand.nextInt(width);
        this.y = rand.nextInt(height);
    }
}
