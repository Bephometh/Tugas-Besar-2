package com.example.christianindrayana.tugasbesar2.Model;

import com.example.christianindrayana.tugasbesar2.Model.Lingkaran;

import java.util.Random;

public class BolaMoveable implements Lingkaran {

    protected int rad = 30;
    protected int x;
    protected int y;


    public int getX() {
        return x;
    }

    public int getRad(){
        return rad;
    }


    public int getY() {
        return y;
    }

    @Override
    public void posistion(int height, int width) {

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int newX, int newY){
        this.x = this.x + newX;
        this.y = this.y + newY;
    }




}
