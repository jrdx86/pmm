package com.example.jorlop01.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ImageView miImagen;
    private TextView lblMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        miImagen = (ImageView) findViewById(R.id.imagen);

        registerForContextMenu(miImagen);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menus this adds items to the action bar if it is present.
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuprincipal,menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_img,menu);

    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada");
                return true;
            case R.id.MenuOpc3:
                lblMensaje.setText("Opcion 3 pulsada");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
