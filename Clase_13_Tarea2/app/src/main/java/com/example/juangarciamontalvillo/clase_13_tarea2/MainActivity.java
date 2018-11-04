package com.example.juangarciamontalvillo.clase_13_tarea2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){

            Fragment unStatic = (Fragment)getSupportFragmentManager().
                    findFragmentById(R.id.statico);
            }
    }
}
