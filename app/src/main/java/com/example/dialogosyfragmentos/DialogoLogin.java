package com.example.dialogosyfragmentos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoLogin extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        // Obtenemos un inflador
        LayoutInflater inflater=requireActivity().getLayoutInflater();

        // Inflamos la vista en el ALertDialog
        builder.setView(inflater.inflate(R.layout.login,null));

        builder.setTitle("Login personalizado");

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Se ha realizado el login", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Se ha cancelado el login", Toast.LENGTH_LONG).show();
            }
        });



        return builder.create();

    }
}
