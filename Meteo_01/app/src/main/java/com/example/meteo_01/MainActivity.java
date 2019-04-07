package com.example.meteo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiClaseMeteo respuestaTask = new MiClaseMeteo();
        respuestaTask.urlString = "https://dl.dropbox.com/s/h8g63l8wcgfvqbf/meteo1.json?dl=1";
        respuestaTask.contex = this;
        respuestaTask.execute();






    }
}
