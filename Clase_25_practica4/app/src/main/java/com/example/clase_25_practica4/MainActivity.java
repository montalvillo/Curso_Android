package com.example.clase_25_practica4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        miClaseMeteo respuestaTask = new miClaseMeteo();
        respuestaTask.urlString = "https://dl.dropbox.com/s/h8g63l8wcgfvqbf/meteo1.json?dl=1";
        respuestaTask.contex = this;
        respuestaTask.execute();


    }

}





