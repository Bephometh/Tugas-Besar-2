package com.example.gabri.tugasbesar2.View;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.gabri.tugasbesar2.Presenter.MyPresenter;

import com.example.gabri.tugasbesar2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected FragmentHome fragHome;
    protected FragmentManager fm;
    protected FragmentStart fragStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.fragStart = FragmentStart.newInstance(this);
        this.fragHome = FragmentHome.newInstance(this);
        this.fm = this.getSupportFragmentManager();

        FragmentTransaction transaction = this.fm.beginTransaction();
        transaction.replace(R.id.fragContainer,fragHome);
        transaction.commit();



    }

    @Override
    public void onClick(View view) {

    }
}
