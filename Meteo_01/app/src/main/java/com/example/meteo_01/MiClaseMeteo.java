package com.example.meteo_01;

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


public class MiClaseMeteo extends AsyncTask {


    private String TAG = getClass().getSimpleName();
    public Activity contex;
    public String urlString = null;

    // public String nombre = null;
    // public String icon = null;
    // private String temperatura = null;

    ArrayList <Ciudad> arrayDeCiudades = new ArrayList <Ciudad>();

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

    @Override
    protected void onPostExecute(Object o) {

        super.onPostExecute(o);
        Log.d(TAG,"*********Esto es el metodo onPostExecute");

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

           //Se crea el array ciudades
           JSONArray ciudades = (JSONArray) jsonObject.get("ciudades");

                //Con este for se lee el JSON, los valores estan en ciudadJSON
                for(Object o:ciudades){

                    JSONObject ciudadJSON = (JSONObject) o;

                    //ciudad toma el valor del nombre del JSON
                    String ciudad = (String) ciudadJSON.get("nombre");
                    String icon = (String) ciudadJSON.get("icon");
                     String temperatura = (String) ciudadJSON.get("temperatura");

                    Log.d(TAG, "Ciudad " + ciudad);
                    Log.d(TAG,"Icon " +icon);
                    Log.d(TAG,"Temperatura "+ temperatura);

                    Ciudad nueva  = new Ciudad(ciudad,icon,temperatura);
                  //arrayDeCiudades.add(new Ciudad(ciudad,icon,temperatura));
                    arrayDeCiudades.add(nueva);


                }
             comprobarCiudades();

            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else  {
            Log.d(TAG, "HTTP conexion fallida ");
        }

        httpURLConnection.disconnect();

    }

    private void comprobarCiudades() {

       for (Ciudad mia  : arrayDeCiudades) {

          Log.d(TAG,"Este es el array de ciudades Ciudad "+ mia.ciudad);
           Log.d(TAG,"Este es el array de ciudades Icon "+ mia.icon);
           Log.d(TAG,"Este es el array de ciudades Temperatura "+ mia.temperatura);

        }

    }}





