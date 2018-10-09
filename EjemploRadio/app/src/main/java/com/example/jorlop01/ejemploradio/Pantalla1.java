package com.example.jorlop01.ejemploradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {


    RadioGroup rg;
    TextView lblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);




        lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        rg = (RadioGroup) findViewById(R.id.gruporb);
        rg.clearCheck();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                if( group.getCheckedRadioButtonId()==R.id.radio1) {
                    lblMensaje.setText("Has elegido la opcion 1");
                    Toast.makeText(Pantalla1.this, lblMensaje.getText(), Toast.LENGTH_SHORT).show();
                }
                if( group.getCheckedRadioButtonId()==R.id.radio2) {
                    lblMensaje.setText("Has elegido la opcion 2");
                    Toast.makeText(Pantalla1.this, lblMensaje.getText(), Toast.LENGTH_SHORT).show();
                }
                }
        });
    }

}
