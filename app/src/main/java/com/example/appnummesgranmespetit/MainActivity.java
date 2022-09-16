package com.example.appnummesgranmespetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int numSec=22;
        final EditText et=findViewById(R.id.NumeroIntroducido);
        final Button b=findViewById(R.id.enviar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                if (Integer.parseInt(et.getText().toString())==numSec){
                    CharSequence text = "Has adivinado el numero!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if (Integer.parseInt(et.getText().toString())<numSec){
                    CharSequence text = "El numero introducido es mas pequeño que el que tienes que adivinar!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    CharSequence text = "El numero introducido es mas grande que el que tienes que adivinar!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

    }
}