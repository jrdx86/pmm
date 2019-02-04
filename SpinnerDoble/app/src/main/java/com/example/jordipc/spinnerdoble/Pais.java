package com.example.jordipc.spinnerdoble;

import java.io.Serializable;

public class Pais implements Serializable {
    private String pais;
    private int capitales;



    public Pais(String pais, int capitales){
        this.pais=pais;
        this.capitales=capitales;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCapitales() {
        return capitales;
    }

    public void setCapitales(int capitales) {
        this.capitales = capitales;
    }
}
