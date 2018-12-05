package com.example.gabri.tugasbesar2.Model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.example.gabri.tugasbesar2.Presenter.MyPresenter;
import com.example.gabri.tugasbesar2.View.FragmentStart;
import com.example.gabri.tugasbesar2.View.MainActivity;

public class SensorReader implements SensorEventListener {

    protected SensorManager sensorManager;
    protected Sensor accelo;
    protected MainActivity activity;
    protected BolaMoveable bola;
    protected FragmentStart fragmentStart;
    protected MyPresenter presenter;
    protected int x;
    protected int y;

    public SensorReader(MainActivity activity) {
        this.activity = activity;
        this.fragmentStart = FragmentStart.newInstance(activity);
        this.presenter = new MyPresenter(activity);
        this.bola = new BolaMoveable();
        this.sensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);//fragmentStart.getActivity().getSystemService(Context.SENSOR_SERVICE);
        this.accelo = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void start(){
        this.sensorManager.registerListener(this,this.accelo,SensorManager.SENSOR_DELAY_GAME);
    }

    public void stop(){
        this.sensorManager.unregisterListener(this,this.accelo);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == accelo)
//            this.x = (int)sensorEvent.values[0];
//            this.y = (int)sensorEvent.values[1];
           this.presenter.updateMoveable((int) sensorEvent.values[0], (int) sensorEvent.values[1]);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
