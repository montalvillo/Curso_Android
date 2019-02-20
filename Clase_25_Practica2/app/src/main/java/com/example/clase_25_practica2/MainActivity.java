package com.example.clase_25_practica2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.clase_25_practica2.R.id.fragment;

public class MainActivity extends AppCompatActivity {

    ArrayList<PropiedadesTiempo> arrayCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hacerRecycle();

        //addFragment();

        //crear una nueva clase y un nuevo objeto de la clase , se puede poner
        //aqui el parametro urlString
        WheaterRequestAsyncTask requestTask = new WheaterRequestAsyncTask();
        //Pasar la url
        requestTask.urlString = "https://api.myjson.com/bins/18mtsy";
        // el contexto es esta activity
        requestTask.contex = this;
        //ejecuta la clase WeatherRequestAsyncTask
        requestTask.execute();




    }




    void hacerRecycle(){

        RecyclerView recyclerViewDeCiudades = (RecyclerView) findViewById(R.id.recycle_view);

        arrayCiudades = new ArrayList <PropiedadesTiempo>();

        listaArrayDeCiudades();


        TiempoAdapter adapter  = new TiempoAdapter(this,arrayCiudades);

        recyclerViewDeCiudades.setAdapter(adapter);
        recyclerViewDeCiudades.setLayoutManager(new LinearLayoutManager(this));
    }

    void listaArrayDeCiudades() {


        arrayCiudades.add(new PropiedadesTiempo("Valladolid","","sol"));

        arrayCiudades.add(new PropiedadesTiempo("Palencia","","nube"));
        arrayCiudades.add(new PropiedadesTiempo("Gerona","","nube") );
    }

}


