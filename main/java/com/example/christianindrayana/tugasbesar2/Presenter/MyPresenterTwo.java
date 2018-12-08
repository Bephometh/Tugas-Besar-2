package com.example.christianindrayana.tugasbesar2.Presenter;


import com.example.christianindrayana.tugasbesar2.View.FragmentStart;
import com.example.christianindrayana.tugasbesar2.View.MainActivity;

public class MyPresenterTwo {

    protected MainActivity activity;
    protected FragmentStart fragStart;

    public MyPresenterTwo(MainActivity activity) {
        this.activity = activity;
        this.fragStart = this.fragStart.newInstance(activity);
    }

    public void updateMoveable(int x, int y){
        this.fragStart.drawMoveable(x,y);
    }
}
