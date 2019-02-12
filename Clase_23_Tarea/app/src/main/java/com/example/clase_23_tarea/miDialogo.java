package com.example.clase_23_tarea;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class miDialogo extends DialogFragment {


    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Aqui deberian ir los datos pero no se ponerlos");

        return builder.create();

    }
}
