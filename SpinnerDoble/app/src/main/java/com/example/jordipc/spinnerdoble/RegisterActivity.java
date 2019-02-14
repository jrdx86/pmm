package com.example.jordipc.spinnerdoble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends AppCompatActivity {
    public static final String LOGGED_CLIENT =
            "com.example.jordipc.spinnerdoble.LOGIN_PLAYER";
    EditText usernameInput;
    EditText passwordInput;
    Button registerButton;
    DatabaseHelper dbHelper = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        dbHelper = new DatabaseHelper(this);
        usernameInput = findViewById(R.id.activity_register_user);
        passwordInput = findViewById(R.id.activity_register_password);
        registerButton = findViewById(R.id.activity_register_btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }
    private void register() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String[] userData = {username, password};
        String[] columns = {

                Globals.TABLE_CLIENT_NAME,
                Globals.TABLE_CLIENT_PASSWORD
        };
        Cursor cursor;
        dbHelper.open();
        cursor = dbHelper.insertItem(Globals.TABLE_CLIENT,columns );
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


}

