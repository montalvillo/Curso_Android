package com.example.juangarciamontalvillo.clase_11_tareas;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void appLocaliza(View view) {

        Uri location = Uri.parse("geo:23.1507652,-82.3584266?z=16");
        Intent verMapa = new Intent(Intent.ACTION_VIEW,location);

        startActivity(verMapa);

        Log.v("MiActivity","Ha funcionado");
        }

    public void appCompartir(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Esto es un texto para enviar al Gran profe Don Angel");

        Intent elegir = Intent.createChooser(intent,"Esto es mio");

       if (intent.resolveActivity(getPackageManager()) !=null);

       startActivity(elegir);

        Log.v("MiActivity","Ha funcionado");

    }


}
