package com.example.christianindrayana.tugasbesar2.Model;

import com.example.christianindrayana.tugasbesar2.Model.Lingkaran;
import com.example.christianindrayana.tugasbesar2.Presenter.MyPresenter;

import java.util.Random;

public class Hole implements Lingkaran {

    protected int x;
    protected int y;
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
