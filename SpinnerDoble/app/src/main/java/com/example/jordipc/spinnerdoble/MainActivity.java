package com.example.jordipc.spinnerdoble;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String LOGGED_CLIENT =
            "com.example.jordipc.spinnerdoble.LOGIN_PLAYER";
    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;
    Button registerButton;
    DatabaseHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);
        usernameInput = findViewById(R.id.activity_login_et_username);
        passwordInput = findViewById(R.id.activity_login_et_password);
        loginButton = findViewById(R.id.activity_login_btn_login);
        registerButton = findViewById(R.id.activity_login_btn_register);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registro = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registro);


            }
        });

    }
    private void login() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String[] userData = {username, password};
        String[] columns = {

                Globals.TABLE_CLIENT_NAME,
                Globals.TABLE_CLIENT_PASSWORD
        };
        Cursor cursor;
        dbHelper.open();
        cursor = dbHelper.getItems(Globals.TABLE_CLIENT, columns, "user = ? AND password = ?",
                userData, Globals.TABLE_CLIENT_ID);
        if (cursor.moveToFirst()) {
            Intent intent = new Intent(this, Pantalla1.class);
            Client client = new Client(cursor.getString(1), cursor.getString(2));
            Bundle bundle = new Bundle();
            bundle.putSerializable(LOGGED_CLIENT, client);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Toast.makeText(this,"No estas registrado, por favor date de alta",Toast.LENGTH_LONG).show();
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        dbHelper.close();
    }


    }





