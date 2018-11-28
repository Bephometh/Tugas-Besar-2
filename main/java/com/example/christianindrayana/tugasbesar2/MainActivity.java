package com.example.christianindrayana.tugasbesar2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected FragmentHome fragHome;
    protected FragmentManager fm;
    protected FragmentStart fragStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.fragHome = FragmentHome.newInstance(this);
        this.fm = this.getSupportFragmentManager();

        FragmentTransaction transaction = this.fm.beginTransaction();
        transaction.replace(R.id.fragContainer,fragHome);
        transaction.commit();
    }

    public void moveFragment(){
        FragmentTransaction transaction = this.fm.beginTransaction();
        transaction.replace(R.id.fragContainer,fragStart);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {

    }
}