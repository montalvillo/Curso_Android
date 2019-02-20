package com.example.clase_25_practica2;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.util.JsonReader;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WheaterRequestAsyncTask extends AsyncTask {


    //Un contexto de la actividad
    public Activity contex;
    //creo la variabble urlString y la inicializo a nul
    public String urlString = null;
    //un TAG para que los Log queden bien
    private String TAG = getClass().getSimpleName();

    // declaro los elementos que van a componer la vista
    private String clima = null;
    private String icon = null ;
    private String temperatura = null;

    //primer metodo del AsyncTask
    @Override
    protected Object doInBackground(Object[] objects) {
        Log.d(TAG,"Soy el metodo doInBaclground");

        try {

            //intenta capturar el JSON
            getWeatherJSON();

            // si no es asi imprime el error

        }catch (IOException e){

            e.printStackTrace();

        }

        return null;
    }

    @Override
    protected void onPostExecute(Object a){

        super.onPostExecute(a);

        Log.d(TAG,"En el metodo onPostExecute");
        updateUI();

    }

    //este metodo es thows porque puede dar un error, que no haya internet, etec

    void getWeatherJSON() throws IOException {


        // creear la url,y le pasa por parametro urlString
        URL url = new URL(urlString);

        //crear conexion
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        //la respuesta se pone null por si no la hay
        InputStream responseBody = null;

        // 200 es que todo fue bien
        if (httpURLConnection.getResponseCode() == 200){

            // se convierte en un getInputString resposeBody
            responseBody = httpURLConnection.getInputStream();

            //luego convertir a un InputStreamReady
            InputStreamReader resposeBodyReader = new InputStreamReader(responseBody,
                    "UTF-8");

            //parsear el JSON me hago un objeto JsonReader y un InputStramReader
            JsonReader jsonReader = new JsonReader(resposeBodyReader);

            //abro el objeto y lo engancho en memoria y se prepara para su posicionamiento
            jsonReader.beginObject();

            while (jsonReader.hasNext()){ //recorrer todas la teclas

                //crear una llave key que va a devolver un nombre
                String key = jsonReader.nextName();//buscar la siguiente elemento(key)

                if (key.equals("clima")){//comprueba si es la llave

                    //obtiene el valor de la cadena
                    String value = jsonReader.nextString();

                    //hacer algo con el valor
                    Log.d(TAG,"Weather funciona");

                    //añadir la propiedad,weather es una propiedad declarada
                    this.clima = value;

                }else if(key.equals("icon")){

                    String value = jsonReader.nextString();

                    Log.d(TAG,"Icon funcionando");

                    this.icon = value;

                }else  if (key.equals("temperatura")){

                    String value = jsonReader.nextString();

                    Log.d(TAG,"temperatura funcionando");

                    this.temperatura = value;

                }else {
                    //omitir valores de otras claves porque no hay mas
                    jsonReader.skipValue();
                }

            }
            //cerrar siempre el JSON
            jsonReader.close();
        }else {
            Log.d(TAG,"HTTP conexion fallida");

        }
        //desconectar la conexion
        httpURLConnection.disconnect();
        //Aqui se termina el  getWeatherJSON() y pasa al onPostExecute
    }


    //actualizar la interface de usuario una vez que se ha realizado la descarga

    void updateUI(){

        ImageView imageView = (ImageView) contex.findViewById(R.id.imageView);
        TextView weatherView = (TextView) contex.findViewById(R.id.ciudad);
        TextView temperatureView =(TextView) contex.findViewById(R.id.temperatura);

        weatherView.setText(clima);
        temperatureView.setText(temperatura);

        //Ajuste de la imagen

        Resources res = contex.getResources();

        //es el icono de lluvia o sol
        int resID = res.getIdentifier(icon,"drawable",contex.getPackageName());
        imageView.setImageResource(resID);

    }

}

