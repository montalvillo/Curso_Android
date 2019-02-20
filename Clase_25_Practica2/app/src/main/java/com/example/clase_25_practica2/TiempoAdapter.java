package com.example.clase_25_practica2;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TiempoAdapter extends RecyclerView.Adapter <TiempoAdapter.ViewHolder> {

    private List<PropiedadesTiempo> tipotiempo;

    private Context context;

    public  static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreCiudad;
        public TextView gradosTemperatura;
        public ImageView imageView;


        public ViewHolder(View itemView){
            super(itemView);

            nombreCiudad = (TextView) itemView.findViewById(R.id.ciudad);
            gradosTemperatura = (TextView ) itemView.findViewById(R.id.temperatura);
            imageView  = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    public  TiempoAdapter(Context context,List<PropiedadesTiempo> datos){

        this.context = context;
        this.tipotiempo = datos;
    }


    private Context getContext(){

        return this.context;
    }


    @NonNull
    @Override
    public TiempoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                       int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View tempView = inflater.inflate(R.layout.layout_plantilla,parent,false);

        ViewHolder viewHolder = new ViewHolder(tempView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


        PropiedadesTiempo tiempo = this.tipotiempo.get(position);

        TextView nombreCiudad = viewHolder.nombreCiudad;
        nombreCiudad.setText(tiempo.ciudad);
        TextView gradosTemperatura = viewHolder.gradosTemperatura;
        gradosTemperatura.setText(tiempo.temperatura);

        ImageView imageView = viewHolder.imageView;

        Resources res = getContext().getResources();
        int resID = res.getIdentifier(tiempo.imageFile,"drawable",getContext().getPackageName());
        imageView.setImageResource(resID);


    }

    @Override
    public int getItemCount() {
        return tipotiempo.size();
    }


}
