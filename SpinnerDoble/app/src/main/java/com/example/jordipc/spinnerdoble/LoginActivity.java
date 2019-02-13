package com.example.jordipc.spinnerdoble;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    public static final String LOGGED_PLAYER =
            "org.institutoserpis.juanminm.proyectofinal.LOGIN_PLAYER";
    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;
    Button registerButton;
    DatabaseHelper dbHelper = null;

    ArrayList<Client> clientesRegistrados = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);
        final EditText usernameInput =(EditText) findViewById(R.id.activity_login_et_username);
        final EditText passwordInput = (EditText) findViewById(R.id.activity_login_et_password);
        loginButton = findViewById(R.id.activity_login_btn_login);
        registerButton = findViewById(R.id.activity_login_btn_register);

        dbHelper.open();



        final Cursor cursorUsuarios = dbHelper.query("SELECT id, name, password FROM " + Globals.TABLE_CLIENT, null);
        if(cursorUsuarios.moveToFirst()) {
            do {
                clientesRegistrados.add(new Client(cursorUsuarios.getString(1), cursorUsuarios.getString(2)));
            } while (cursorUsuarios.moveToNext());
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<clientesRegistrados.size();i++ ){
                    if(usernameInput.getText().toString() == clientesRegistrados.get(i).toString())
                }
                //comparas con el nombre del array
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}

