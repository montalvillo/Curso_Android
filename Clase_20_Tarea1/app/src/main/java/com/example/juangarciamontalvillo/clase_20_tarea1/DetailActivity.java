package com.example.juangarciamontalvillo.clase_20_tarea1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {


    private List<PropiedadesEstatua> arrayDeEstatuas;
    private EstatuasAdapter.ViewHolder viewHolder;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int position = getIntent().getIntExtra("clave",-1);

        Log.v("en el detail activity","posocion" + Integer.toString(position));


        //construir la fuente de datos

        arrayDeEstatuas = new ArrayList <PropiedadesEstatua>();

        //llenar el array
        fillArrayDeEstatuas();

        PropiedadesEstatua miEstatua = arrayDeEstatuas.get(position);

       // Log.v("DetailActivity","nombre "+ miEstatua.nombre);
        //Log.v("DetailActivity","nombre "+ miEstatua.imageFile);

        TextView nombreText = (TextView)findViewById(R.id.nombreActivity);
        TextView nombreDescripcion = (TextView)findViewById(R.id.nombreDescripcion);
        //ImageView miImagen = (ImageView)findViewById(R.id.imageActivity) ;

        nombreText.setText(miEstatua.nombre);
        nombreDescripcion.setText(miEstatua.descripcion);

        ImageView imageView = (ImageView)findViewById(R.id.imageActivity);

       Resources res = getContext().getResources();
        int resID = res.getIdentifier(miEstatua.imageFile, "drawable", getContext().getPackageName());

        imageView.setImageResource(resID);

       //miImagen.setImageResource(R.drawable.ghandi);



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



    private Context getContext() {

        return this;//devuelve el contexto, contex es la propiedad

    }



}
