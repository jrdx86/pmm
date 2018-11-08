package com.example.jorlop01.ejemplocanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
        //setContentView(R.layout.activity_main);
        Toast.makeText(this, "Dibujar circulo", Toast.LENGTH_SHORT).show();
        View vista = (View)findViewById(R.id.vista);

        reDraw(vista);
    }
    class MiDibujo extends View {
        private ShapeDrawable miDrawable;
        private ShapeDrawable miDrawable2;
        public MiDibujo (Context c){
            super(c);
        }
        public MiDibujo(Context c, AttributeSet a){
            super(c,a);
        }

        protected  void onDraw (Canvas lienzo){
            Paint miPincel = new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
            lienzo.drawCircle(720,1056,300,miPincel);
            miPincel.setTextSize(60);
            lienzo.drawText("MI CIRCULO", 0, 500, miPincel);
            String mensaje = "Ancho: "+getWidth() + " Alto: " + getHeight();
            lienzo.drawText(mensaje,500,500,miPincel);
            Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();
            lienzo.drawLine(0,0,600,600, miPincel);

            int x=200;
            int y=200;
            int ancho = 100;
            int alto = 100;
            miDrawable = new ShapeDrawable(new RectShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y, x + ancho, y + alto);

            miDrawable.draw(lienzo);

            int x1=1200;
            int y1=200;
            int ancho1 = 100;
            int alto1 = 100;
            miDrawable2 = new ShapeDrawable(new RectShape());
            miDrawable2.getPaint().setColor(0xff0000ff);
            miDrawable2.setBounds(x1,y1, x1 + ancho1, y1 + alto1);

            miDrawable2.draw(lienzo);
        }
    }

    public  void reDraw(View v){

    }

}

