package com.example.jorlop01.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dam2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dam2);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent miIntent = new Intent(Dam2.this,Pantalla2.class);

                Bundle miBundle=new Bundle();

                String mensajePaso = "Te saludo " + miTexto.getText();

                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
        });


        Toast.makeText(this,"esto es un TOAST!", Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(this).setMessage("el Texto").setPositiveButton(android.R.string.ok, null).show();

    }
}