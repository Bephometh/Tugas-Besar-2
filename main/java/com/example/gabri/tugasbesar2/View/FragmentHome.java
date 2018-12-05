package com.example.gabri.tugasbesar2.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gabri.tugasbesar2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment implements View.OnClickListener{
    protected MainActivity activity;
    protected Button btnStart,btnExit;
    protected FragmentStart fragStart;
    protected FragmentManager fm;
    public FragmentHome() {
        // Required empty public constructor
    }

    public static FragmentHome newInstance(MainActivity mainActivity){
        FragmentHome result = new FragmentHome();
        result.activity = mainActivity;
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_fragment_home, container, false);
        this.btnStart = result.findViewById(R.id.btnStart);
        this.btnExit = result.findViewById(R.id.btnExit);
        this.btnStart.setOnClickListener(this);
        this.btnExit.setOnClickListener(this);
        this.fragStart = FragmentStart.newInstance(activity);
        this.fm = activity.getSupportFragmentManager();
        return result;
    }

    @Override
    public void onClick(View view) {
        if(view == this.btnStart){
            FragmentTransaction transaction = this.fm.beginTransaction();
            transaction.replace(R.id.fragContainer,fragStart);
            transaction.commit();

        }
        else if(view == this.btnExit){
            System.exit(0);
        }
    }
}
