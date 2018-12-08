package com.example.christianindrayana.tugasbesar2.View;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christianindrayana.tugasbesar2.Model.SensorReader;
import com.example.christianindrayana.tugasbesar2.R;
import com.example.christianindrayana.tugasbesar2.Model.ThreadTime;
import com.example.christianindrayana.tugasbesar2.Model.UIWrapperTime;
import com.example.christianindrayana.tugasbesar2.Presenter.MyPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStart extends Fragment implements View.OnClickListener{
    protected MainActivity activity;
    protected Bitmap mbitmap;
    protected ImageView ivCanvas;
    protected Canvas mCanvas;
    protected Paint paint;
    protected Button start;
    protected TextView tvTime;
    protected int ivHeight;
    protected int ivWidth;
    protected MyPresenter presenter;
    protected SensorReader sensorReader;
    protected ThreadTime threadTime;
    protected UIWrapperTime uiWrapperTime;
    protected int count=0;
    public String scoreTime;

    public FragmentStart() {
        // Required empty public constructor
    }

    public static FragmentStart newInstance(MainActivity mainActivity){
        FragmentStart result = new FragmentStart();
        result.activity = mainActivity;
        result.sensorReader = new SensorReader(result.activity, result);
        return result;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_fragment_start, container, false);
        this.ivCanvas = result.findViewById(R.id.iv_canvas);
        this.start = result.findViewById(R.id.btn_start);
        this.tvTime = result.findViewById(R.id.tvTime);

        this.start.setOnClickListener(this);


        return result;
    }

    public void changeTime(String newTime){
        this.tvTime.setText(newTime);
    }

    @Override
    public void onPause() {
        super.onPause();
        this.sensorReader.stop();
    }

    /**
     * Method to create canvas
     */
    public void initiateCanvas(){
        this.paint = new Paint();
        this.mbitmap = Bitmap.createBitmap(this.ivCanvas.getWidth(),this.ivCanvas.getHeight(),Bitmap.Config.ARGB_8888);
        this.ivCanvas.setImageBitmap(this.mbitmap);
        this.mCanvas = new Canvas(this.mbitmap);
        this.ivHeight = this.ivCanvas.getHeight();
        this.ivWidth = this.ivCanvas.getWidth();
        this.presenter = new MyPresenter(activity);

        this.paint.setColor(Color.RED);
        int moveX = 200;
        int moveY = 100;
        mCanvas.drawCircle(moveX , moveY,30, paint);

        this.presenter.drawCircles(this.ivHeight,this.ivWidth);


        this.sensorReader.start();
    }

    /**
     * draw the hole and the ball
     * @param x coordinarte of the ball
     * @param y coordinate of the ball
     */
    public void drawMoveable(int x, int y){
        clearCanvas();

        int holeX =this.presenter.holeX();
        int holeY =this.presenter.holeY();
        this.paint.setColor(Color.BLACK);
        mCanvas.drawCircle(holeX,holeY,35, paint);
        this.ivCanvas.invalidate();
        //adjust speed;
        int speed = 1;
        this.presenter.setMoveable(x * speed,y * speed);

        //Check bounds of moveable circle
        if(this.presenter.moveableX() <= 0 + 30){
            this.presenter.setMoveableX( 0 + 30 * speed);
        }
        else if( this.presenter.moveableX() >= this.ivWidth -30){
            this.presenter.setMoveableX(this.ivWidth - 30 * speed);
        }
        else if(this.presenter.moveableY() <= 0 + 30){
            this.presenter.setMoveableY(0 + 30 * speed);
        }
        else  if(this.presenter.moveableY() >= this.ivHeight - 30){
            this.presenter.setMoveableY(this.ivHeight - 30 * speed);
        }


        this.paint.setColor(Color.RED);
        mCanvas.drawCircle(this.presenter.moveableX()  ,this.presenter.moveableY(),30, paint);
        this.ivCanvas.invalidate();

        if(this.presenter.moveableX() == holeX && this.presenter.moveableY()== holeY){
            this.sensorReader.stop();
            this.threadTime.stopTimer();
            this.scoreTime = this.tvTime.getText().toString();
        }
    }


    /**
     * Method to clear canvas
     */
    protected void clearCanvas(){
        this.mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        this.ivCanvas.invalidate();
    }


    @Override
    public void onClick(View view) {
        if(view == start){
                initiateCanvas();
            this.uiWrapperTime = new UIWrapperTime(this);
            this.threadTime = new ThreadTime(this.uiWrapperTime);
                this.threadTime.start();
        }
    }
}
