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
    int contador=0;
    int contganar=0;
    int numSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numSec=(int)(Math.random()*(100-1+1)+1);
        EditText et=findViewById(R.id.NumeroIntroducido);
        final Button b=findViewById(R.id.enviar);
        TextView intent=findViewById(R.id.intentos);
        TextView registro=findViewById(R.id.registro);
        TextView ganar=findViewById(R.id.ganar);
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        registro.setMovementMethod(new ScrollingMovementMethod());
        b.setOnClickListener(new View.OnClickListener() {

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
                    intent.setText("Intentos: "+contador);
                    if (Integer.parseInt(et.getText().toString()) == numSec) {
                        CharSequence text = "Has adivinado el numero!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        registro.append("Has adivinado el numero!\n");
                        builder.setTitle("Felicidades").setMessage("Has acertado!\n"+intent.getText().toString()+"\nDale a aceptar para generar un nuevo numero\nSe reiniciaran los intentos y se borrara el registro").setCancelable(false).setPositiveButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        numSec=(int)(Math.random()*(100-1+1)+1);
                                        contador=0;
                                        intent.setText("Intentos: "+contador);
                                        registro.setText("");
                                        contganar++;
                                        ganar.setText("Partidas ganadas: "+contganar);

                                    }
                                });
                        AlertDialog alerta= builder.create();
                        alerta.show();


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
                    et.setText("");
                }
            }
        });

    }
}