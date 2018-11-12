package com.example.jorlop01.alquilerdecoches;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    public Coches[] coches = new Coches []{
            new Coches("Megane","Renault",false,false,false,false,false,0,0,R.drawable.megan1),
            new Coches("X-11","Ferrari",false,false,false,false,false,0,0,R.drawable.ferrari1),
            new Coches("Leon","Seat",false,false,false,false,false,0,0,R.drawable.leon1),
            new Coches("Fiesta","Ford",false,false,false,false,false,0,0,R.drawable.fiesta1)
    };

    public Coches [] mialquiler;
    public int indice = 0;
    public Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);


        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorZonas miAdaptador = new AdaptadorZonas(this);
        spinner.setAdapter(miAdaptador);
        spinner.setSelection(-1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indice = position;
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        final RadioButton bSin_seguro = (RadioButton) findViewById(R.id.sin_seguro);
        final RadioButton bSeguro = (RadioButton) findViewById(R.id.con_seguro);
        final CheckBox checkBoxAire = (CheckBox) findViewById(R.id.aire);
        final CheckBox checkBoxGps = (CheckBox) findViewById(R.id.gps);
        final CheckBox checkBoxRadio = (CheckBox) findViewById(R.id.radio);
        Button calcular = (Button) findViewById(R.id.calcular);
        final RadioGroup tarifas = (RadioGroup) findViewById(R.id.tarifas);
        final EditText horas = (EditText) findViewById(R.id.horas);
        final Object texto = spinner.getSelectedItem();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                if(bSin_seguro.isChecked()){
                    coches[indice].setSin_seguro(true);
                    flag = true;
                }else if(bSeguro.isChecked()){
                    coches[indice].setSeguro(true);
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Tienes que elegir modalidad de seguro",Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if(checkBoxAire.isChecked()){
                    coches[indice].setAire(true);
                }else if(checkBoxGps.isChecked()){
                    coches[indice].setGps(true);
                }else if(checkBoxRadio.isChecked()){
                    coches[indice].setRadio(true);
                }
                String comparador = horas.getText().toString();
                if(comparador.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Debes introducir las horas de alquiler",Toast.LENGTH_SHORT).show();
                    flag = false;
                }else{
                    coches[indice].setHoras(Integer.parseInt(horas.getText().toString()));
                }
                if (flag == true){
                    Intent intent = new Intent(Pantalla1.this, Pantalla2.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Objeto", coches[indice]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflate  = getMenuInflater();
        inflate.inflate(R.menu.menu_principal, menu);
        return true;
    }

        class AdaptadorZonas extends ArrayAdapter {
            Activity context;
            AdaptadorZonas(Activity context){
                super(context, R.layout.cocheslista, coches);
                this.context = context;
            }
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                View vista = getView(position, convertView, parent);
                return vista;
            }
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public View getView(int position, View convertiView, ViewGroup parent){
                LayoutInflater inflater = context.getLayoutInflater();
                View item = inflater.inflate(R.layout.cocheslista, null);
                TextView modelo = (TextView) item.findViewById(R.id.modelo);
                TextView marca = (TextView) item.findViewById(R.id.marca);
                TextView precio = (TextView) item.findViewById(R.id.precio);
                ImageView imagen = (ImageView) item.findViewById(R.id.coche);
                modelo.setText(coches[position].getModelo());
                modelo.setText(coches[position].getMarca());
                precio.setText(String.valueOf(coches[position].getPrecio()));
                imagen.setBackground(getDrawable(coches[position].getImagen()));

                return item;
            }
        }
}
