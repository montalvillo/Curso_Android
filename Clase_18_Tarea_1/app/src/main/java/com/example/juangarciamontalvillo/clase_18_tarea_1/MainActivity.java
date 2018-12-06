package com.example.juangarciamontalvillo.clase_18_tarea_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listaPaises);
    }


    public void onResume(){

        super.onResume();

        unaSimpleLista();


    }


    void unaSimpleLista(){


        String [] listaPaises = {"Alemania","Austria","Belgica","Chipre","Eslovaquia","Eslovenia","España"
                ,"Estonia","Finlandia","Francia","Grecia","Irlanda","Italia","Letonia","Lituania","Luxenburgo"
                ,"Malta","Paises Bajos","Portugal"};


        ArrayAdapter<String> adapter = new ArrayAdapter <String>(this,R.layout.item
                ,R.id.textView,listaPaises);

        listView.setAdapter(adapter);

    }
}
