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
    int numSec;
    static ArrayList<Usuario> usuarios=new ArrayList<Usuario>();

    static public ArrayList<Usuario> getUsuarios() {
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
        final Button rec=findViewById(R.id.paginarecord);
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
                        AlertDialog.Builder guardar=new AlertDialog.Builder(MainActivity.this);
                        registro.append("Has adivinado el numero!\n");
                        EditText nombre=new EditText(MainActivity.this);
                        guardar.setView(nombre);
                        guardar.setTitle("Guardar datos").setMessage("Quieres guardar tu record?\nSi quieres guardar los datos por favor introduzca un nombre").setPositiveButton("Guardar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        usuarios.add(new Usuario(nombre.getText().toString(),contador));
                                        contador=0;
                                        intent.setText("Intentos: "+contador);
                                    }

                                    }).setNegativeButton("No guardar",new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            contador=0;
                                            intent.setText("Intentos: "+contador);


                                        }

                                    });
                        AlertDialog guardarD= guardar.create();
                        guardarD.show();
                        numSec=(int)(Math.random()*(100-1+1)+1);
                        Log.i("Info","Este es el valor "+String.valueOf(numSec));//quitar esto al final;
                        registro.setText("");

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
                startActivity(intent1);

            }
        });
    }
}