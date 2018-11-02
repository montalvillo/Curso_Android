package com.example.juangarciamontalvillo.clase_13_tarea_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadirFragment();

    }


    public void añadirFragment (){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PrimerFragment fragment = new PrimerFragment();
        fragmentTransaction.add(R.id.fragmentoUno,fragment);
        fragmentTransaction.commit();

        }
}
