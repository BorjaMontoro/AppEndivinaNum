package com.example.appnummesgranmespetit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int numSec=(int)(Math.random()*(100-1+1)+1);
        final EditText et=findViewById(R.id.NumeroIntroducido);
        final Button b=findViewById(R.id.enviar);
        final TextView intent=findViewById(R.id.intentos);
        final TextView registro=findViewById(R.id.registro);
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        registro.setMovementMethod(new ScrollingMovementMethod());
        b.setOnClickListener(new View.OnClickListener() {
            int contador=0;
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                if (et.getText().length()==0) {
                    CharSequence text = "Introduce un numero!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    contador++;
                    if (Integer.parseInt(et.getText().toString()) == numSec) {
                        CharSequence text = "Has adivinado el numero!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        registro.append("Has adivinado el numero!\n");
                        builder.setTitle("Has acertado!").setMessage("Dale a aceptar para generar un nuevo numero").setPositiveButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });


                    } else if (Integer.parseInt(et.getText().toString()) < numSec) {
                        CharSequence text = "El numero "+et.getText().toString()+" es mas pequeño que el que tienes que adivinar!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        registro.append("El numero "+et.getText().toString()+" es mas pequeño que el que tienes que adivinar!\n");
                    } else {
                        CharSequence text = "El numero "+et.getText().toString()+" es mas grande que el que tienes que adivinar!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        registro.append("El numero "+et.getText().toString()+" es mas grande que el que tienes que adivinar!\n");
                    }
                    intent.setText("Intentos: "+contador);
                    et.setText("");
                }
            }
        });

    }
}