package com.example.lucas.botonera;

/**
 * Created by lucas on 22/5/2017.
 */

public class Boton {
    private int audio;

    public Boton(int aud){
        this.audio = aud;
    }
    public void setAudio(int n){
        audio = n;
    }
    public int getAudio(){
        return audio;
    }
}
