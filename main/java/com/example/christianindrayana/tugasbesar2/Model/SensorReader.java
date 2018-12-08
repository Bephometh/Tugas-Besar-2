package com.example.christianindrayana.tugasbesar2.Model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.example.christianindrayana.tugasbesar2.Presenter.MyPresenter;
import com.example.christianindrayana.tugasbesar2.View.FragmentStart;
import com.example.christianindrayana.tugasbesar2.View.MainActivity;

public class SensorReader implements SensorEventListener {

    protected SensorManager sensorManager;
    protected Sensor accelo;
    protected MainActivity activity;
    protected FragmentStart fragmentStart;
    protected MyPresenter presenter;

    public SensorReader(MainActivity activity, FragmentStart fragmentStart) {
        this.activity = activity;
        this.fragmentStart = fragmentStart;
        this.presenter = new MyPresenter(activity);
        this.sensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
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
        {
            this.fragmentStart.drawMoveable((int) sensorEvent.values[0] *-1 , (int) sensorEvent.values[1]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
