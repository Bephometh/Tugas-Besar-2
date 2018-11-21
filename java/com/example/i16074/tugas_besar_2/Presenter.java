package com.example.i16074.tugas_besar_2;

public class Presenter {

    public MainActivity activity;
    protected SensorReader sensorReader;
    protected ScoreCounter scoreCount;


    public Presenter(MainActivity activity) {
        this.activity = activity;
        this.sensorReader = new SensorReader(activity);
    }

    public void getTotalScore(){
        this.scoreCount.getScore();
    }
}