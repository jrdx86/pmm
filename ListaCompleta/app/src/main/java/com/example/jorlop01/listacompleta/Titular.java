package com.example.jorlop01.listacompleta;

public class Titular {
    String titulo;
    String subtitulo;
    public  Titular (String tit, String subTit){
        this.titulo = tit;
        this.subtitulo = subTit;
    }

    String getTitulo(){
        return titulo;
    }
    String getSubtitulo(){
        return subtitulo;
        }

    void setTitulo(String tit){
        this.titulo=tit;
    }

    void setSubtitulo(String subTit){
        this.subtitulo=subTit;
    }

    public String toString(){
        return  titulo + " "+ subtitulo+"\n";
    }
}
