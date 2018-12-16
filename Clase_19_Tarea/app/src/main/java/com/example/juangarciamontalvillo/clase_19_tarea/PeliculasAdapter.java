package com.example.juangarciamontalvillo.clase_19_tarea;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PeliculasAdapter extends RecyclerView.Adapter <PeliculasAdapter.ViewHolder> {

    private List <PropiedadesPelicula> peliculaslista;

    private Context context;



    public static class ViewHolder extends RecyclerView.ViewHolder {



        public TextView tituloTextView;
        public TextView generoTextView;
        public ImageView imageView;

        public ViewHolder(View itemView){

            super(itemView);

            tituloTextView = (TextView) itemView.findViewById(R.id.tituloText);
            generoTextView = (TextView) itemView.findViewById(R.id.generoText);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

            }

    }


    public PeliculasAdapter(Context context,List <PropiedadesPelicula> pelis){

        this.context = context;
        this.peliculaslista = pelis;


    }

    private  Context getContext(){

        return this.context;
    }




    @Override
    public PeliculasAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType){

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View peliView = inflater.inflate(R.layout.forma_layout,parent,false);

        ViewHolder viewHolder = new ViewHolder(peliView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        PropiedadesPelicula pelicula = this.peliculaslista.get(position);

        TextView tituloTextView = viewHolder.tituloTextView;
        tituloTextView.setText(pelicula.titulo);
        TextView generoTextView = viewHolder.generoTextView;
        generoTextView.setText(pelicula.genero);

        ImageView imageView = viewHolder.imageView;

        Resources res = getContext().getResources();
        int resID = res.getIdentifier(pelicula.imageFile,"drawable",getContext().getPackageName());
         imageView.setImageResource(resID);

         }

    @Override
    public int getItemCount() {
        return peliculaslista.size();
    }



}
