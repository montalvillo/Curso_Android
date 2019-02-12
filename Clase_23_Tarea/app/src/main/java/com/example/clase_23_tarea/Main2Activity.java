package com.example.clase_23_tarea;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        irFragment();
    }


    void irFragment() {

            FragmentManager fragmentManager = getSupportFragmentManager();
            getSupportFragmentManager();
            miDialogo miDialogo = new miDialogo();
            miDialogo.show(fragmentManager, "");

    }}