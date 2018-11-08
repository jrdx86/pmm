package com.example.jorlop01.objetolistas;


import java.io.Serializable;

public class Titular implements Serializable{
        String titulo;
        String subtitulo;
        int imagen;

        public  Titular (String tit, String subTit,int imagen){
            this.titulo = tit;
            this.subtitulo = subTit;
            this.imagen=imagen;
        }

        int getImagen(){
            return imagen;
        }
        String getSubtitulo(){
        return subtitulo;
    }
        String getTitulo(){
            return titulo;
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
