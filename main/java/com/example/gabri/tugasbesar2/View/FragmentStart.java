package com.example.gabri.tugasbesar2.View;


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

import com.example.gabri.tugasbesar2.Model.SensorReader;
import com.example.gabri.tugasbesar2.Presenter.MyPresenter;
import com.example.gabri.tugasbesar2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStart extends Fragment implements View.OnClickListener {
    protected MainActivity activity;
    protected Bitmap mbitmap;
    protected ImageView ivCanvas;
    protected Canvas mCanvas;
    protected Paint paint;
    protected Button start;
    protected int ivHeight;
    protected int ivWidth;
    protected MyPresenter presenter;

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
        this.start = result.findViewById(R.id.btn_start);

        this.start.setOnClickListener(this);
        this.presenter = new MyPresenter(activity);

        return result;
    }

    @Override
    public void onPause() {
        super.onPause();
        this.presenter.stopSensor();
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

        this.paint.setColor(Color.RED);
        int moveX = 200;
        int moveY = 100;
        mCanvas.drawCircle(moveX , moveY,30, paint);

        this.presenter.drawCircles(this.ivHeight,this.ivWidth);

        this.presenter.startSensor();
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

        this.presenter.setMoveable(x,y);

        //Check bounds of moveable circle
        if(this.presenter.moveableX() <= 0 + 30){
            this.presenter.setMoveableX( 0 + 30);
        }
        else if( this.presenter.moveableX() >= this.ivWidth -30){
            this.presenter.setMoveableX(this.ivWidth - 30);
        }
        else if(this.presenter.moveableY() <= 0 + 30){
            this.presenter.setMoveableY(0 + 30);
        }
        else  if(this.presenter.moveableY() >= this.ivHeight - 30){
            this.presenter.setMoveableY(this.ivHeight - 30);
        }

        //adjust speed;
        int speed = 15;
        x += x  * speed;
        y += y * speed;

        this.paint.setColor(Color.RED);
        mCanvas.drawCircle(this.presenter.moveableX()  ,this.presenter.moveableY(),30, paint);
        this.ivCanvas.invalidate();

        if(this.presenter.moveableX() == holeX && this.presenter.moveableY()== holeY){
            this.presenter.stopSensor();
        }
    }



    protected void clearCanvas(){
        this.mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        this.ivCanvas.invalidate();
    }


    @Override
    public void onClick(View view) {
        if(view == start){
            initiateCanvas();
        }
    }
}
