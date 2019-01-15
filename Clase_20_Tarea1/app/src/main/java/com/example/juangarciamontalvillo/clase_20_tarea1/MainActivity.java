package com.example.juangarciamontalvillo.clase_20_tarea1;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Propiedad
    ArrayList<PropiedadesEstatua> arrayDeEstatuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void onResume(){
        super.onResume();

        //buscar el "recycler_wiew" en el diseño del xlm activity_main
        //para tener un puntero "recyclerViewDeEstatuas" a la vista

        RecyclerView recyclerViewDeEstatuas = (RecyclerView) findViewById(R.id.recycler_view);

        //Construir el array de datos
        arrayDeEstatuas = new ArrayList <PropiedadesEstatua>();

        //contruir el array de estatuas con el este metodo

        fillArrayDeEstatuas();

        //Crear el adaptador para convertir el array en vistas con los datos
        //que necesita el contex y los datos de donde va a tirar el adapter

        EstatuasAdapter adapter = new EstatuasAdapter(this,arrayDeEstatuas);

        //conectar el adaptador para enganchar el recycle_view en el adapter
        //Aqui se llama alos metodos de construcion y la vista se pone en pantalla

        recyclerViewDeEstatuas.setAdapter(adapter);

        //Asigna un nuevo layout manager en este contexto (this)
        //LinearLayoutManager puede se otra cosa
        // y llamo al metodo

        recyclerViewDeEstatuas.setLayoutManager(new LinearLayoutManager(this));

        }


    private void fillArrayDeEstatuas() {

        arrayDeEstatuas.add((new PropiedadesEstatua("Arlequin Sentado","Arlequin sentado : Situada en la calle Nuñez de Arce de Valladolid.\n" + "Autor: Angel Membiela.\n" + "Inagurada en el año 1998 por el entonces alcalde Francisco Javier de la Riva.\n" + "\n" + "Arlequín realizado en bronce y sentado sobre una pieza de granito.\n" + "Dimensiones: 200x80x80 Cm.\u2028\n" + "Peso: 100 Kg.\u2028\n" +
                "Original en acero corten en propiedad del autor.",
                "arlequin")));
        arrayDeEstatuas.add(new PropiedadesEstatua("Ghandi","Mahatma Gandhi: Situada " +
                "en el interior del Parque de la Paz, en el barrio de las Delicias, al sur de Valladolid."+
                "\n" + "Donada por el Gobierno de la India en el año 2001. Sobre un alto pedestal, aparece la figura del pacifista indio impulsor del movimiento de no violencia en posición de meditación, sentado en el suelo, con los ojos cerrados y su túnica por encima. Fue un regalo de la India a la Ciudad de Valladolid. Es uno de los principales " +
                "reclamos de este entorno verde de la ciudad.",
                "ghandi"));
        arrayDeEstatuas.add(new PropiedadesEstatua("Guardia Urbano","Guardia Urbano:" +
                " Situada en la calle Maria de Molina en Valladolid." + "Autora: Ana Hernando + " +
                "Inagurada en el año 2002 por el entonces alcalde Francisco Javier de la Riva."  +
                "Un homenaje a la Policía Municipal. Una estatua de 3,90 m. de altura y 400 kg. de peso " +
                "fundida en bronce y patinada en el tono verde que aparece de la oxidación natural" +
                " del metal y que representa a un guardia urbano:" +
                "El eléctrico dirigiendo el tráfico desde su peana","guardia"));
        arrayDeEstatuas.add(new PropiedadesEstatua("Niña Leyendo","Niña Leyendo:" +
                " Situada en la Plaza de las Batallas de Valladolid." +
                "Autora: Belen gonzalez." + "Inagurada en el año 2002 por el entoces" +
                " alcalde Francisco Javier de la Riva." + "\n" + "Escultura en bronce " +
                "sin peana de 2,80 m. de altura que representa a una adolescente leyendo el libro" +
                " \"Sara de U\" de José Jiménez Lozano. La escultora tomó como modelo a su hija Elisa" +
                " y está pensada para que los niños suban y jueguen con ella.\n","leyendo"));
        arrayDeEstatuas.add(new PropiedadesEstatua("San Pedro Regalado","San Pedro Regalado:" +
                " Situada en la Plaza del Salvador en Valladoliod. " + "Autor: Miguel Garcia delgado. "
                + "Inagurada en el año 2004 por el entoces alcalde Francisco Javier de la Riva.\n" + "\n" +
                "Es el patron de Valladolid. " + "\n" + "Escultura en bronce de 2,30 metros de altura " +
                "que reposa sobre un pedestal de casi tres metros." + "San Pedro Regalado aparece con " +
                "el habitual hábito de los franciscanos, portando el cíngulo en la cintura," +
                " descalzo y de pie. El misticismo de su rostro y la mano ligeramente" +
                " adelantada del cuerpo, simulan la postura que debió adoptar cuando " +
                "paró a un toro bravo en uno de sus viajes entre Valladolid y" +
                " el cenobio burgalés de La Aguilera.","sanpedro"));
        arrayDeEstatuas.add(new PropiedadesEstatua("El Toro sin Orejas","El toro sin " +
                "orejas: Situada en el Paseo de Zorrilla a la altura del antiguo matadero. " + "Autor:" +
                "Inagurada en el año 1999 por el entonces alcalde Francisco Javier de la Riva.\n" +
                "\n"  + "Esta escultura está situada en el Paseo Zorrilla. El toro está mirando " +
                "al antiguo y desaparecido matadero municipal. La escultura es un homenaje al artista " +
                "José Luis Medina. Este artista a los toros que pintaba y esculpía no les ponía orejas."
                ,"toro"));

    }

}
