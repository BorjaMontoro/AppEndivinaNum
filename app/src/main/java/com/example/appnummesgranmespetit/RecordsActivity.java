package com.example.appnummesgranmespetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        TextView records=findViewById(R.id.record);
        records.setMovementMethod(new ScrollingMovementMethod());
        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
//        ArrayList<Usuario> usuarios=(ArrayList<Usuario>) extras.get("Records");
//        for (Usuario usu:usuarios){
//            Log.i("INFO",String.valueOf(usu));
//        }
    }
}