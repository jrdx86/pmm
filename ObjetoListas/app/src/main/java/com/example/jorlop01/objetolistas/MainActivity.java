package com.example.jorlop01.objetolistas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Titulo1", "Subtitulo largo 1", R.drawable.img1),
            new Titular("Titulo2", "Subtitulo largo 2", R.drawable.img2),
            new Titular("Titulo1", "Subtitulo largo 3", R.drawable.img3),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView IstOpciones = (ListView) findViewById(R.id.LstOpciones);
        IstOpciones.setAdapter(adaptador);

        IstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo: " + datos[position].getTitulo() + ".Subtitulo: " + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView imagen;
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.activity_adapter, datos);
            this.context = context;
        }

        /*@TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_adapter, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.tvTitulo);
            lblTitulo.setText(datos[i].getTitulo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
            lblSubtitulo.setText(datos[i].getSubtitulo());

            ImageView imagen =(ImageView) item.findViewById(R.id.ivlImagen);
            imagen.setBackground(getDrawable(datos[i].getImagen()));

            return (item);
        }
    }*/
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;
            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.activity_adapter, null);

                holder = new ViewHolder();
                holder.titulo = (TextView) item.findViewById(R.id.tvTitulo);
                holder.subtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
                holder.imagen =(ImageView) item.findViewById(R.id.ivlImagen);


                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }
            holder.titulo.setText(datos[position].getTitulo());
            holder.subtitulo.setText(datos[position].getSubtitulo());
            holder.imagen.setBackground(getDrawable(datos[position].getImagen()));
            return (item);

        }
    }
}