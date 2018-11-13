package com.example.juangarciamontalvillo.clase_14_trea;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadirClocks();
    }

    public void añadirClocks(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        ClockFragment fragment1 = new ClockFragment();
        fragmentTransaction.add(R.id.fragmentClock1,fragment1);
        fragmentTransaction.commit();
        fragment1.setTimeColor("GMT","red");


        fragmentTransaction = fragmentManager.beginTransaction();
        ClockFragment fragment2 = new ClockFragment();
        fragmentTransaction.add(R.id.fragmentClock2,fragment2);
        fragmentTransaction.commit();
        fragment2.setTimeColor("CET","green");

        fragmentTransaction = fragmentManager.beginTransaction();
        ClockFragment fragment3 = new ClockFragment();
        fragmentTransaction.add(R.id.fragmentClock3,fragment3);
        fragmentTransaction.commit();
        fragment3.setTimeColor("EST","blue");

        fragmentTransaction = fragmentManager.beginTransaction();
        ClockFragment fragment4 = new ClockFragment();
        fragmentTransaction .add(R.id.fragmentClock4,fragment4);
        fragmentTransaction.commit();
        fragment4.setTimeColor("GIT","yellow");


    }


}
