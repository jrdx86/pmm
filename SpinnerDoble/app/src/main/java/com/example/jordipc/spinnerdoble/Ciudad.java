package com.example.jordipc.spinnerdoble;

public class Ciudad {
    private String ciudad;
    private int poblacion;


    public Ciudad(String ciudad, int poblacion){
        this.setCiudad(ciudad);
        this.setPoblacion(poblacion);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
}
