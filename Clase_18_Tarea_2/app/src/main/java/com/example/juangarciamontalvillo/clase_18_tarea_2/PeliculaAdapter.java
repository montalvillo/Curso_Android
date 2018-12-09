package com.example.juangarciamontalvillo.clase_18_tarea_2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {


    public  PeliculaAdapter(Context context, ArrayList<Pelicula> peli){

        super(context,0,peli);

        }

        public View getView(int position, View convertView, ViewGroup parent){

        Pelicula pelicula =  getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.formas,parent,false);

        }

            TextView titulo = (TextView) convertView.findViewById(R.id.tituloText);
            TextView genero = (TextView) convertView.findViewById(R.id.generoText);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

            titulo.setText(pelicula.titulo);
            genero.setText(pelicula.genero);

            Resources img = getContext().getResources();

            int imgID = img.getIdentifier(pelicula.imageFile,"drawable",getContext().getPackageName());

            imageView.setImageResource(imgID);

            return convertView;
        }
}
