package com.example.juangarciamontalvillo.clase_14_trea;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class ClockFragment extends Fragment {

    //Propiedades para asignar y mover datos dentro de la clase

    TextView tiempoTextView;
    TextView localizacionTextView;

    String tiempoZona;
    String color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Vincular las propiedades con los fragment
        tiempoTextView =(TextView) getView().findViewById(R.id.tiempo);
        localizacionTextView = (TextView) getView().findViewById(R.id.localizacion);

        setTimeAndZone(); //metodo para poner el tiempo
        setBackgroundColor(); //metodo para poner el color

    }

    public void setTimeColor(String tiempoZona, String color){

        this.tiempoZona = tiempoZona;
        this.color = color;


    }
    public void setBackgroundColor(){

        tiempoTextView.setBackgroundColor(Color.parseColor(this.color));
        localizacionTextView.setBackgroundColor(Color.parseColor(color));

    }

    //Este metodo calcula el tiempo en reloj del movil
    public void setTimeAndZone() {

        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(tiempoZona));
        String timestamp = simpleDateFormat.format(currentDate);

        tiempoTextView.setText(timestamp);
        localizacionTextView.setText(tiempoZona);

        updatelLabelTimes(); //este metodo actualiza la hora
    }


    public void updatelLabelTimes(){

        int interval = 10000;
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                ClockFragment.this.setTimeAndZone();

            }
        };

        handler.postAtTime(runnable,System.currentTimeMillis()+interval);
        handler.postDelayed(runnable,interval);
    }
}


