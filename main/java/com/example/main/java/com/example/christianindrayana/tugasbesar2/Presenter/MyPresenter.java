package com.example.christianindrayana.tugasbesar2.Presenter;

import com.example.christianindrayana.tugasbesar2.Model.ThreadTime;
import com.example.christianindrayana.tugasbesar2.Model.UIWrapperTime;
import com.example.christianindrayana.tugasbesar2.View.FragmentStart;
import com.example.christianindrayana.tugasbesar2.View.MainActivity;
import com.example.christianindrayana.tugasbesar2.Model.BolaMoveable;
import com.example.christianindrayana.tugasbesar2.Model.Hole;
import com.example.christianindrayana.tugasbesar2.Model.SensorReader;

public class MyPresenter {

    protected MainActivity activity;
    protected BolaMoveable moveable;
    protected Hole hole;


    public MyPresenter(MainActivity activity) {
        this.activity = activity;
        this.hole = new Hole();
        this.moveable = new BolaMoveable();
    }



    /**
     * Method to get randomized hole position
     */
    public void drawCircles(int height, int width){
        this.hole.posistion(height,width);

        if(200 == this.holeX() &&100 == this.holeY()){
            drawCircles(height, width);
        }
        else{

        }

    }




    public int moveableX(){return  this.moveable.getX();}

    public int moveableY(){return  this.moveable.getY();}

    /**
     * Method to get moveable x
     */
    public void setMoveableX(int x){
        this.moveable.setX(x);
    }

    /**
     * Method to get moveable y
     */
    public void setMoveableY(int y){
        this.moveable.setY(y);
    }


    /**
     * Method to set moveableBall x and y
     */
    public void setMoveable(int x, int y){
        this.moveable.move(x,y);
    }

    /**
     * Method to get hole x
     */
    public int holeX(){
        return (int) this.hole.getX();
    }

    /**
     * Method to get hole y
     */
    public int holeY(){
        return (int) this.hole.getY();
    }
}
