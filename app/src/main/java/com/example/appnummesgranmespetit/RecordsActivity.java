package com.example.appnummesgranmespetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        TextView records=findViewById(R.id.record);
        final Button vol=findViewById(R.id.volver);
        records.setMovementMethod(new ScrollingMovementMethod());
        ArrayList<Usuario> usuarios = MainActivity.getUsuarios();
        for (Usuario usu:usuarios){
            Log.i("INFO",String.valueOf(usu));
        }
        vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(RecordsActivity.this,MainActivity.class);
                startActivity(intent2);

            }
        });
    }
}