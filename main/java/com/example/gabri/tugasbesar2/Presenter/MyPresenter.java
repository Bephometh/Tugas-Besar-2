package com.example.gabri.tugasbesar2.Presenter;

import android.util.Log;

import com.example.gabri.tugasbesar2.View.FragmentStart;
import com.example.gabri.tugasbesar2.View.MainActivity;
import com.example.gabri.tugasbesar2.Model.BolaMoveable;
import com.example.gabri.tugasbesar2.Model.Hole;
import com.example.gabri.tugasbesar2.Model.SensorReader;

public class MyPresenter {

    public MainActivity activity;
    protected FragmentStart fragStart;
    protected SensorReader sensorReader;
    protected BolaMoveable moveable;
    protected Hole hole;


    public MyPresenter(MainActivity activity) {
        this.activity = activity;
        this.fragStart = this.fragStart.newInstance(activity);
        this.hole = new Hole();
        this.moveable = new BolaMoveable();
        this.sensorReader = new SensorReader(activity);

    }

    public void startSensor(){
        this.sensorReader.start();
    }

    public void stopSensor(){
        this.sensorReader.stop();
    }

    public void drawCircles(int height, int width){
        this.hole.posistion(height,width);

        if(200 == this.holeX() &&100 == this.holeY()){
            drawCircles(height, width);
        }
        else{

        }

    }

    public void updateMoveable(int x, int y){
        this.fragStart.drawMoveable(x,y);
    }


    public int moveableX(){return (int) this.moveable.getX();}

    public int moveableY(){return (int) this.moveable.getY();}

    public void setMoveableX(int x){
        this.moveable.setX(x);
    }

    public void setMoveableY(int y){
        this.moveable.setY(y);
    }


    public void setMoveable(int x, int y){
        this.moveable.move(x,y);
    }

    public int holeX(){
        return (int) this.hole.getX();
    }

    public int holeY(){
        return (int) this.hole.getY();
    }
}
