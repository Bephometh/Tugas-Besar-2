package com.example.christianindrayana.tugasbesar2;

import android.os.Handler;
import android.os.Message;

public class UIWrapperTime extends Handler{
    protected FragmentStart fragmentStart;
    protected final static int MSG_SET_CHANGETIME=0;

    protected UIWrapperTime(FragmentStart fragmentStart){
        this.fragmentStart = fragmentStart;
    }

    public void handleMessage(Message msg){
        if(msg.what == UIWrapperTime.MSG_SET_CHANGETIME){
            String result = (String) msg.obj;
            this.fragmentStart.changeTime(result);
        }
    }

    public void changeTime(String output){
        Message msg = new Message();
        msg.what = MSG_SET_CHANGETIME;
        msg.obj = output;
        this.sendMessage(msg);
    }

}
