package com.example.alifkhadaffa.tugas_besar_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentFinish extends Fragment implements View.OnClickListener{
    protected MainActivity activity;
    protected TextView tvYourScore , tvHighScore;
    protected Button buttonSettings , buttonExit;
    protected FragmentStart fragStart;
    protected FragmentManager fm;
    private int highScorenow = 0;

    public FragmentFinish(){

    }

    public static FragmentFinish newInstance(MainActivity mainactivity) {
        FragmentFinish frag = new FragmentFinish();
        frag.activity = mainactivity;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_fragment_finish, container, false);
        this.tvYourScore =  result.findViewById(R.id.yourScore);
        this.tvHighScore = result.findViewById(R.id.highScore);
        //check();
        this.buttonSettings = result.findViewById(R.id.btnSettings);
        this.buttonExit = result.findViewById(R.id.btnExit);
        this.fragStart = FragmentStart.newInstance(activity);

        this.fm = activity.getSupportFragmentManager();

        this.buttonExit.setOnClickListener(this);
        this.buttonSettings.setOnClickListener(this);

        return result;
    }
    @Override
    public void onClick(View view) {
        if (view == buttonSettings){
            Intent intent = new Intent(getActivity() , SettingsActivity.class);
            startActivity(intent);
        }

        else if(view == buttonExit){
            System.exit(0);
        }
    }

//    public void check(){
//        int newScore = getScoreNow();//ngambil dari TextView score
//        int highScore = Integer.valueOf(tvHighScore.getText().toString());//high score pas di fragment score
//
//        //kondisi kalau high score sama newScorenya belom ada
//        if(highScorenow < newScore){
//            tvHighScore.setText(newScore+"");
//            highScorenow = newScore;
//            tvHighScore.setText("NEW HIGH SCORE");
//        }
//        else{
//            tvHighScore.setText(highScorenow+"");
//            tvYourScore.setText(getScoreNow()+"");
//        }
//    }

//    public int getScoreNow(){
//        int res = activity.presenter.getTotalScore();
//        return res;
//    }
}
