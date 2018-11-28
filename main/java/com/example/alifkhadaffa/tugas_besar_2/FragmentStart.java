package com.example.alifkhadaffa.tugas_besar_2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStart extends Fragment implements View.OnClickListener{
    protected MainActivity activity;
    protected Bitmap mbitmap;
    protected ImageView ivCanvas;
    protected Canvas mCanvas;
    protected Button btn;
    protected FragmentFinish fragFinish;
    protected FragmentManager fm;
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
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        mCanvas.drawCircle(200,200,20, paint);
        this.btn = result.findViewById(R.id.btnPindah);
        this.fragFinish = FragmentFinish.newInstance(activity);
        this.fm = activity.getSupportFragmentManager();
        this.btn.setOnClickListener(this);
        return result;
    }

    @Override
    public void onClick(View view) {
        if (view == this.btn){
            FragmentTransaction transaction = this.fm.beginTransaction();
            transaction.replace(R.id.fragContainer,fragFinish);
            transaction.commit();
        }
    }
}