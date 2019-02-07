package com.example.jordipc.spinnerdoble;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleFragment extends Fragment {

    int imagen;
    static SimpleFragment newInstance(int imagen) {
        SimpleFragment f = new SimpleFragment();
        // Mantenemos el numero para usarlo en cualquier momento.
        Bundle args = new Bundle();
        args.putInt("imagen", imagen);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtenemos el numero que se habia pasado como argumento en
        // la creacion de la instancia
        imagen = getArguments().getInt("imagen");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.frame_simple, container, false);
        ImageView imagen1 = (ImageView) view.findViewById(R.id.image);

        ((ImageView)imagen1).setImageResource(imagen);



        return view;
    }
}