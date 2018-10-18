package com.example.jorlop01.objetolistas;


    public class Titular {
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
