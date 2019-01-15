package com.example.juangarciamontalvillo.clase_20_tarea1;

 import android.content.ClipData;
 import android.content.Context;
 import android.content.Intent;
 import android.content.res.Resources;
 import android.provider.Telephony;
 import android.support.annotation.NonNull;
 import android.support.v7.widget.RecyclerView;
 import android.util.Log;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ImageView;
 import android.widget.ResourceCursorAdapter;
 import android.widget.TextView;

 import java.util.List;

//Esta clase recibe un tipo de vista que es un ViewHolder
public class EstatuasAdapter extends RecyclerView.Adapter<EstatuasAdapter.ViewHolder> {
    // no añado los constructores , los añado despues

    // Almaceno en esta variable la lista de estatuas
    private List <PropiedadesEstatua> estatuaList;

    //Esta propiedad se crea para guardar en contex el contexto porque el  Adapter
    // no esta en el activity, contex es un puntero al contexto
    private Context context;


    //En esta clase declaro las propiedades de los datos que necesito
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreTextView;
        public TextView descripcionTextView;
        public ImageView imageView;

        //Constructor de la clase ViewHolder recibe un itemView que va a llamar al itemView

        public ViewHolder(@NonNull View itemView) {
            super(itemView);//el itemView se pasa a la clase super

            //Enganchar los elementos
            nombreTextView = (TextView) itemView.findViewById(R.id.nameText);
            descripcionTextView = (TextView) itemView.findViewById(R.id.descripcionTex);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    //creo  ahora el constructor de la clase EstatuasAdapter
    //necesito dar lo datos al contex y estos datos estan en la nueva variable "estatuas"

    public EstatuasAdapter(Context context, List <PropiedadesEstatua> estatuas) {
        //contex es el Adapter para saber en que Activity estoi porque se le van
        // a volcar los datos y las vistas

        this.context = context;

        //los datos son la lista de estatuas  "estatuas"

        this.estatuaList = estatuas;
    }
    // para tener facil acceso al objeto de contexto en el recyclerview, para mayor comodidad

    private Context getContext() {

        return this.context;//devuelve el contexto, contex es la propiedad

    }


    //Hay que hacer un ViewHolder.Crear las nuevas vistas(invocando al layout manager)
    //esta clase recibe un ViewGroup por el parametro parent
    //int es un numero del tipo de vista

    public EstatuasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //la variable contex pertenece a esta clase, es local y se pasa como parametro a parent
        Context context = parent.getContext();

        //inflar la vista para pasarsela al contex de la clase
        LayoutInflater inflater = LayoutInflater.from(context);

        //Crear una nuena vista e inflarla

        View estatuasView = inflater.inflate(R.layout.formas_layout, parent, false);

        // estatuasView es el "formas_layout xlm"
        //Devolver una nueva instancia del layout manager
        //Se crea un nuevo ViewHolder que es un puntero a la vista "formas_layout" ya inflada

        ViewHolder viewHolder = new ViewHolder(estatuasView);


        return viewHolder;//devuelve el viewHolder
    }


    //reemplazar el contenido de una vista(invocado por el layouyt manager
    //esta clase engancha los contenidos de la vista del viewHolder
    //esta clase pasa el viewHolder nuestro que esta definido en la clase static ViewHolder
    // saca la posicion con el int
    @Override
    public void onBindViewHolder(EstatuasAdapter. ViewHolder viewHolder, final int position) {

        // coge el array de datos (estatuaList) por la posicion y se lo damos a una nueva variable
        //  llamad "estatu"
        PropiedadesEstatua estatu = this.estatuaList.get(position);

        //Establecer vistas de elementos segun sus vista y modelos de datos

        TextView nombreTextView = viewHolder.nombreTextView;
        nombreTextView.setText(estatu.nombre);//id del xlm formas_layout y se le asigna


        //Desactivado para que no salga la dewscripcion en la primera vista

        //TextView descripcionTextView = viewHolder.descripcionTextView;
        //descripcionTextView.setText(estatu.descripcion);//id del xlm formas_layout y se le asigna

        ImageView imageView = viewHolder.imageView;//id del xlm formas_layout y se le asigna

        //Ajuste de la imagen
        Resources res = getContext().getResources();

        int resID = res.getIdentifier(estatu.imageFile, "drawable", getContext().getPackageName());
        imageView.setImageResource(resID);

        //selecciona al hacer clik en cualquier lugar con itemView
        //si se cambia itemView por un nombre solo cuando acepte al nombre

    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           irDetalleActivity(position);


           // Log.v("soy un cartel","estoi en la posicion" + position);

        }


    });

    }


    //este metodo llama a la nueva activity "DetailActivity" y le añade un nuevo
    //elemento , la llamada se hace con un Intent
    private void irDetalleActivity(int position) {

        Intent i = new Intent(this.context,DetailActivity.class);

        i.putExtra("clave",position);//añadimos un dicci
        this.context.startActivity(i);

        }


   //este metodo devuelve el tamaño de su conjunto de datos(invocados por layout manager
    //retorna cuantas veces debe de correr segun el numero de elememntos del array
    @Override
    public int getItemCount() {
        return estatuaList.size();
    }

}

