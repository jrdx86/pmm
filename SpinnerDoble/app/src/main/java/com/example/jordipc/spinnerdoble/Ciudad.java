package com.example.jordipc.spinnerdoble;

public class Ciudad {
    private String ciudad;
    private int poblacion;
    private int imagen;

    public Ciudad(String ciudad, int poblacion, int imagen){
        this.ciudad=ciudad;
        this.poblacion=poblacion;
        this.imagen=imagen;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}