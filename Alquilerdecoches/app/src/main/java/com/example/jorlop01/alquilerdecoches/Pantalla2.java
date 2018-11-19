
package com.example.jorlop01.alquilerdecoches;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    int tot;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Intent intent = getIntent();
        Coches coche = (Coches) intent.getSerializableExtra("Objeto");
        final TextView modelo = (TextView) findViewById(R.id.modelo2);
        final TextView extras = (TextView) findViewById(R.id.extras);
        final TextView tiempo = (TextView) findViewById(R.id.tiempo);
        final TextView seguro = (TextView) findViewById(R.id.seguro);
        final TextView total = (TextView) findViewById(R.id.total);
        final ImageView cche = (ImageView) findViewById(R.id.coche);

        modelo.setText(coche.getModelo());
        tiempo.setText(String.valueOf(coche.getHoras()));
        cche.setBackground(getDrawable(coche.getImagen()));


        if(coche.getSin_Seguro()== true){
            seguro.setText("Sin seguro");
        }
        if(coche.getSeguro()== true){
            seguro.setText("Con seguro");
        }
        if (coche.getRadio() == true){
            tot+=50;
        }
        if (coche.getAire() == true){
            tot+=50;
        }
        if(coche.getGps() == true){
            tot+=50;
        }
        extras.setText(String.valueOf(tot));


    }
}
