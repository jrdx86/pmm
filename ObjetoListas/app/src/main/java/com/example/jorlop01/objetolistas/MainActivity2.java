package com.example.jorlop01.objetolistas;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView titulo = (TextView)findViewById(R.id.titulo2);
        TextView subtitulo =(TextView)findViewById(R.id.subtitulo2);
        ImageView img =(ImageView)findViewById(R.id.imagen2);

        Titular titular = (Titular) getIntent().getSerializableExtra("objeto");

        titulo.setText(titular.getTitulo());
        subtitulo.setText(titular.getSubtitulo());
        img.setBackground(getDrawable(titular.getImagen()));
    }
}
