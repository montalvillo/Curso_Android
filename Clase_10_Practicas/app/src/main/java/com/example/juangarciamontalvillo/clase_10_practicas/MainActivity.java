package com.example.juangarciamontalvillo.clase_10_practicas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void abrirDireccion(View view){

        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.es/maps"));
        startActivity(i);


    }
}
