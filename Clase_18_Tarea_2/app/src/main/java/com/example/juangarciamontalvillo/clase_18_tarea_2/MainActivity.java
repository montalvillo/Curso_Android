package com.example.juangarciamontalvillo.clase_18_tarea_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Pelicula> arrayDePelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.mio);
    }


    public void onResume(){

        super.onResume();
        construirObjetoPelicula();
    }

    void construirObjetoPelicula() {

        arrayDePelicula = new ArrayList <Pelicula>();

        datosArayDePelicula();

        PeliculaAdapter adapter = new PeliculaAdapter(this,arrayDePelicula);

        listView.setAdapter(adapter);
    }

    private void datosArayDePelicula() {

        arrayDePelicula.add(new Pelicula("Dragon Oculto","Artes Marciales","dragon_oculto"));
        arrayDePelicula.add(new Pelicula("Amores Perros","Drama","amores_perros"));
        arrayDePelicula.add(new Pelicula("Divididos Caemos","Drama","divididos_caemos"));
        arrayDePelicula.add(new Pelicula("Todos Famosos","Comedia","todos_famosos"));
        arrayDePelicula.add(new Pelicula("Sabor de los Demas","Thiller","sabor_demas"));
    }
}
