package com.example.appnummesgranmespetit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int contador=0;
    int contganar=0;
    int numSec;
    ArrayList<Usuario> usuarios=new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
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
        AlertDialog.Builder guardar=new AlertDialog.Builder(MainActivity.this);
        EditText nombre=new EditText(this);
        final Button rec=findViewById(R.id.paginarecord);
        registro.setMovementMethod(new ScrollingMovementMethod());
        Log.i("Info","Este es el valor "+String.valueOf(numSec));//quitar esto al final
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
                                        guardar.setTitle("Guardar datos").setMessage("Quieres guardar tu record?\nSi quieres guardar los datos porfavor introduzca un nombre").setView(nombre).setPositiveButton("Si",
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        usuarios.add(new Usuario(nombre.getText().toString(),contador));

                                                    }

                                    }).setNegativeButton("No",new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {



                                            }

                                        });
                                        AlertDialog guardarD= guardar.create();
                                        guardarD.show();
                                    }
                                });
                        AlertDialog alerta= builder.create();
                        alerta.show();


                    } else if (Integer.parseInt(et.getText().toString()) < numSec) {
                        CharSequence text = "El numero que tienes que adivinar es mas grande que "+et.getText().toString();
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        registro.append("El numero que tienes que adivinar es mas grande que "+et.getText().toString()+"\n");
                    } else {
                        CharSequence text = "El numero que tienes que adivinar es mas pequeño que "+et.getText().toString();
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        registro.append("El numero que tienes que adivinar es mas pequeño que "+et.getText().toString()+"\n");
                    }
                    et.setText("");
                }
            }
        });
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,RecordsActivity.class);
                intent1.putExtra("Records",usuarios);
                startActivity(intent1);

            }
        });
    }
}