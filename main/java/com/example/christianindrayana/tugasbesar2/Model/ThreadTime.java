package com.example.christianindrayana.tugasbesar2.Model;

public class ThreadTime implements Runnable {
    protected Thread thread;
    protected UIWrapperTime uiWrapperTimer;
    protected long seconds,minutes,secs;
    protected boolean running;
    protected String time;
    public ThreadTime(UIWrapperTime uiWrapper){
        this.uiWrapperTimer = uiWrapper;
        this.thread = new Thread(this);
        this.seconds = 0;
        this.running = true;
    }

    @Override
    public void run() {
        if(running) {
            seconds++;
        }
        minutes = (seconds % 3600) / 60;
        secs = seconds % 60;

        time = String.format("%02d:%02d", minutes, secs);

        this.uiWrapperTimer.changeTime(time);
        this.uiWrapperTimer.postDelayed(this,1000); //delay 1 sec

    }

    public void start(){
        this.thread.start();
    }

    public void stop(){

    }

    public void stopTimer(){
        this.running = false;

    }

    public String getTime(){
        return this.time;
    }
}
