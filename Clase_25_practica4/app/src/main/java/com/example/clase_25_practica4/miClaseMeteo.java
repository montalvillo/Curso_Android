package com.example.clase_25_practica4;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class miClaseMeteo extends AsyncTask {


    private String TAG = getClass().getSimpleName();
    public Activity contex;
    public String urlString = null;

   // public String nombre = null;
   // public String icon = null;
   // private String temperatura = null;


    ArrayList<Ciudades> miListado = new ArrayList<Ciudades>();

    @Override
    protected Object doInBackground(Object[] objects) {

        Log.d(TAG,"Empieza el metodo doInBackgound");

try {
    getUnoJSON();//metodo para capturar al json


}catch (IOException e){
    e.printStackTrace();
}

        return null;
    }

    protected void onPostExecute(Object o) {

        super.onPostExecute(o);

    }


    void getUnoJSON() throws  IOException {

        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        InputStream respuesta = null;//se pone a null por si no hay respuesta.

        if (httpURLConnection.getResponseCode() == 200) {
            respuesta = httpURLConnection.getInputStream();
            InputStreamReader respuestaReader = new InputStreamReader(respuesta, "UTF-8");

            //Crear JSON para parsear

            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject)jsonParser.parse(respuestaReader);

                org.json.simple.JSONArray ciudades = (JSONArray) jsonObject.get("ciudades");

                ArrayList <String> miListado = new ArrayList <>();

                for(Object o: ciudades){
                    JSONObject ciudadJSON = (JSONObject) o;
                    String ciudad = (String) ciudadJSON.get("nombre");
                    String temperatura = (String) ciudadJSON.get("temperatura");
                    String icon = (String) ciudadJSON.get("icon");
                    Log.d(TAG, "Ciudad " + ciudad);
                    Log.d(TAG, "Temperatura " + temperatura);
                    Log.d(TAG,"Icono " + icon);


                    miListado.add(ciudad);
                    miListado.add(temperatura);
                    miListado.add(icon);

                    Log.d(TAG,"ciudad nueva"+ miListado);

                    comprobarCiudades();

                }





            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else  {
            Log.d(TAG, "HTTP conexion fallida ");
        }

httpURLConnection.disconnect();



    }

    private void comprobarCiudades() {



        for (Object nombre : miListado){

        }



    }}



































