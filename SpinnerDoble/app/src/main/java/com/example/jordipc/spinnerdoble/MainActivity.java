package com.example.jordipc.spinnerdoble;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Spinner spinner2;
    int imagen;

    public int indice;
    public int indice2;

    ArrayList imagenes = new ArrayList();

    public Pais[] pais = new Pais[]{

            new Pais("España ",7),
            new Pais("Francia ",8),
            new Pais("Alemania ",9)
    };
    public Ciudad[][] ciudad = new Ciudad[][]{


            {new Ciudad("Valencia ", 1000000,R.drawable.valencia), new Ciudad("Madrid",600000,R.drawable.madrid),new Ciudad("Sevilla",500000,R.drawable.sevilla)},
            {new Ciudad("Paris ",8000000,R.drawable.paris), new Ciudad("Niza",1000000,R.drawable.niza),new Ciudad("Burdeos",200000,R.drawable.burdeos)},
            {new Ciudad("Berlin ",8000000,R.drawable.berlin), new Ciudad("Munich",5000000,R.drawable.munich),new Ciudad("Frankfurt",600000,R.drawable.frankfurt)},


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spinner = (Spinner) findViewById(R.id.spinner);

        AdaptadozZonas miAdaptador = new AdaptadozZonas(this);
        spinner.setAdapter(miAdaptador);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               indice = position;

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        AdaptadorZonasCiudad miAdaptador1 = new AdaptadorZonasCiudad(this);
        spinner2.setAdapter(miAdaptador1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                imagen = ciudad[indice][position].getImagen();
                addFragment();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    class AdaptadozZonas extends ArrayAdapter {
        Activity context;

        AdaptadozZonas(Activity context) {
            super(context, R.layout.pais_lista, pais);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vista = getView(position, convertView, parent);
            return vista;
        }

        public View getView(int position, View convertiView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.pais_lista, null);
            TextView Pais = (TextView) item.findViewById(R.id.pais);
            TextView Capital = (TextView) item.findViewById(R.id.capital);

            Pais.setText(pais[position].getPais());
            Capital.setText(String.valueOf(pais[position].getCapitales()));

            return item;
        }

    }
    class AdaptadorZonasCiudad extends ArrayAdapter {
        Activity context;

        AdaptadorZonasCiudad(Activity context) {
            super(context, R.layout.ciudad_lista, ciudad);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vista = getView(position, convertView, parent);
            return vista;
        }

        public View getView(int position, View convertiView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.ciudad_lista, null);

            TextView Ciudad = (TextView) item.findViewById(R.id.ciudad2);
            TextView Poblacion = (TextView)item.findViewById(R.id.poblacion);


            Ciudad.setText(ciudad[indice][position].getCiudad());
            //hay que hacer un cast a string ya que el metodo setText() solo acepta string
            Poblacion.setText(String.valueOf(ciudad[indice][position].getPoblacion()));

            return item;

        }


        }
        public void addFragment() {

        Fragment newFragment = SimpleFragment.newInstance(imagen);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        ft.addToBackStack(null);
        ft.commit();
    }

    }





