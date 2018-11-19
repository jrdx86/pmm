package com.example.jorlop01.alquilerdecoches;

import java.io.Serializable;

public class Coches implements Serializable {
    public String modelo, marca;
    boolean sin_seguro=false, seguro=false,aire=false,gps=false,radio=false;
    int horas, imagen,precio, extra;

    public Coches (String modelo, String marca, boolean sin_seguro, boolean seguro, boolean aire, boolean gps, boolean radio, int horas,
                    int precio, int extra, int imagen){
        this.modelo=modelo;
        this.marca=marca;
        this.sin_seguro=sin_seguro;
        this.seguro=seguro;
        this.aire=aire;
        this.gps=gps;
        this.radio=radio;
        this.horas=horas;
        this.imagen=imagen;
        this.precio=precio;
        this.extra=extra;

    }
    public void setExtra(int extra) {
        this.extra = extra;
    }

    public int getExtra() {
        return extra;
    }

    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setSin_seguro(boolean sin_seguro) {
        this.sin_seguro = sin_seguro;
    }
    public boolean getSin_Seguro(){
        return sin_seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }
    public boolean getSeguro(){
        return seguro;
    }

    public void setAire(boolean aire) {
        this.aire = aire;
    }
    public boolean getAire(){
        return aire;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }
    public boolean getGps(){
        return gps;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }
    public boolean getRadio(){
        return radio;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
