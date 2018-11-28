package com.example.christianindrayana.tugasbesar2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStart extends Fragment{
    protected MainActivity activity;
    protected Bitmap mbitmap;
    protected ImageView ivCanvas;
    protected Canvas mCanvas;
    protected TextView tvTime;
    protected ThreadTime threadTime;
    protected UIWrapperTime uiWrapperTime;
    public FragmentStart() {
        // Required empty public constructor
    }

    public static FragmentStart newInstance(MainActivity mainActivity){
        FragmentStart result = new FragmentStart();
        result.activity = mainActivity;
        return result;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View result = inflater.inflate(R.layout.fragment_fragment_start, container, false);
        this.ivCanvas = result.findViewById(R.id.iv_canvas);
        this.mbitmap = Bitmap.createBitmap(500,700,Bitmap.Config.ARGB_8888);
        this.ivCanvas.setImageBitmap(this.mbitmap);
        this.mCanvas = new Canvas(this.mbitmap);
        this.tvTime = result.findViewById(R.id.tvTime);
        this.uiWrapperTime = new UIWrapperTime(this);
        this.threadTime = new ThreadTime(this.uiWrapperTime);
        this.threadTime.start();

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        mCanvas.drawCircle(200,200,20, paint);

        return result;
    }

    public void changeTime(String newTime){
        this.tvTime.setText(newTime);
    }

}
