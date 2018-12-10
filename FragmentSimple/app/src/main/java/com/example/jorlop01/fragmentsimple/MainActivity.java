package com.example.jorlop01.fragmentsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View miFragmento;
    Button aparece;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miFragmento= (View) findViewById(R.id.ejemplo);
        aparece= (Button)findViewById(R.id.button);
        miFragmento.setVisibility(View.INVISIBLE);
        aparece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(miFragmento.getVisibility() == View.INVISIBLE){
                    miFragmento.setVisibility(View.VISIBLE);
                }else miFragmento.setVisibility(View.INVISIBLE);
            }
        });
    }
}
