package com.example.gabri.tugasbesar2;

public class Presenter {

    public MainActivity activity;
    protected SensorReader sensorReader;


    public Presenter(MainActivity activity) {
        this.activity = activity;
        this.sensorReader = new SensorReader(activity);
    }
}
