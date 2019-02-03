package com.example.jordipc.spinnerdoble;

import java.io.Serializable;

public class Pais implements Serializable {
    private String pais;

    public Pais(String pais){
        this.setPais(pais);

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}
