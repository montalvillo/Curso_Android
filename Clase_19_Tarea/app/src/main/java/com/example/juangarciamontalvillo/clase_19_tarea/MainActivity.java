package com.example.juangarciamontalvillo.clase_19_tarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PropiedadesPelicula> arrayDePeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResume(){

        super.onResume();
        hacerRecycle();
    }


    void hacerRecycle(){

        RecyclerView recyclerViewDePeliculas = (RecyclerView) findViewById(R.id.recycle_view);

        arrayDePeliculas = new ArrayList <PropiedadesPelicula>();

        listaArrayDePeliculas();

        PeliculasAdapter adapter = new PeliculasAdapter(this,arrayDePeliculas);

        recyclerViewDePeliculas.setAdapter(adapter);
        recyclerViewDePeliculas.setLayoutManager(new LinearLayoutManager(this));



    }
     void listaArrayDePeliculas() {


        arrayDePeliculas.add(new PropiedadesPelicula("Viaje de la esperanza",
                "Drama","viaje_esperanza"));
        arrayDePeliculas.add(new PropiedadesPelicula("Cyrano de Bergerac",
                "Drama","cyrano"));
        arrayDePeliculas.add(new PropiedadesPelicula("JU DOU","Tragedia","ju_dou"));
        arrayDePeliculas.add(new PropiedadesPelicula("La chica desagradable",
                "Drama","chica"));
        arrayDePeliculas.add(new PropiedadesPelicula("Puertas abirtas",
                "Drama","puertas"));
    }}

