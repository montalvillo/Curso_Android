package com.example.clase_23_tarea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       guardarDatos();
        leerDatos();

        Button button1 = (Button)findViewById(R.id.botonIr);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),Main2Activity.class);
                startActivityForResult(intent, 0);

            }
        });
    }


    void guardarDatos(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("string","Soy el string guardado");
        editor.putInt("Valor",34);
        editor.apply();
    }


    void leerDatos(){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String usarNombre = preferences.getString("string",null);
        int numero = preferences.getInt("Valor",34);

        Log.v("********Mensaje","Soy el mensaje del string************" + String.valueOf(usarNombre));
        Log.v("*********Otro mensaje","mensaje del int "+ numero);

    }


}
