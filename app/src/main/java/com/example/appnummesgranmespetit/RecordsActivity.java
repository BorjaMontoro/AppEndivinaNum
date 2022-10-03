package com.example.appnummesgranmespetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        final Button vol=findViewById(R.id.volver);
        ArrayList<Usuario> usuarios = MainActivity.getUsuarios();

        //make sure that the lists contain data or else display will be blank screen

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableLayout tbl=(TableLayout) findViewById(R.id.tabla);
        for(Usuario usu:usuarios)
        {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView txt1=new TextView(this);
            TextView txt2=new TextView(this);
            //setting the text
            txt1.setText(usu.getNombre());
            txt2.setText(String.valueOf(usu.getIntentos()));
;
            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);
            row.setLayoutParams(params2);
            tbl.addView(row);
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