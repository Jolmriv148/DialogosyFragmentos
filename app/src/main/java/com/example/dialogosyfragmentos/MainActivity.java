package com.example.dialogosyfragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    CheckBox cb;
    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        cb=findViewById(R.id.cb);
        tv=findViewById(R.id.tv);
        tv2=findViewById(R.id.tv2);
    }

    public void reloj(View view) {
        TimePickerDialog t=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                et2.setText(i+":"+i1);
            }
        },12,0,true);

        t.show();
    }

    public void calendario(View view) {
        DatePickerDialog d=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                et1.setText(i+"/"+(i1+1)+"/"+i2);
            }
        },2022,0,1);

        d.show();
    }

    public void comprobarCb(View view) {
        if(cb.isChecked()){
            AlertDialog.Builder builder= new AlertDialog.Builder(this);

            builder.setTitle("Diálogo simple");
            builder.setMessage("Clique confirmar para un mensaje");
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(),"Se ha pulsado confirmar",Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancelar",null);

            builder.create();

            builder.show();
        }

    }

    public void DialogoSeleccionSimple(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("Seleccione un color");

        String[] colores={"Green","Blue","Red"};
        builder.setItems(colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText("Se ha seleccionado "+colores[i]);
            }
        });

        builder.create().show();

    }

    public void dialogoSeleccionMultiple(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("Seleccione uno o varios días");

        String[] dias={"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};

        // Viable para guardar los días seleccionados
        ArrayList<String> diasSeleccionados = new ArrayList<String>();

        builder.setMultiChoiceItems(dias, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                // Si se selecciona
                if(b){
                    if(!diasSeleccionados.contains(dias[i])) {
                        diasSeleccionados.add(dias[i]);
                    }

                }else if(diasSeleccionados.contains(dias[i])){ // Si un elemento seleccionado se deseleeciona
                    // Borramos el elemento
                    diasSeleccionados.remove(i);
                }
            }
        });

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String texto="Ha seleccionado";
                for(String t:diasSeleccionados){
                    texto+=" "+t;
                }
                tv2.setText(texto);
            }
        });

        builder.setNegativeButton("Cancelar",null);

        builder.create().show();
    }

    public void dialogoVistaPersonalizada(View view) {
        DialogoLogin dl=new DialogoLogin();
        dl.show(getSupportFragmentManager(),"prueba");
    }


}