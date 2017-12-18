package com.example.lucas.botonera;

import android.support.annotation.NonNull;

/**
 * Created by lucas on 25/7/2017.
 */

public class Audio  {
    private int soundId;
    private String nombre;
    private int idPersona;
    private String autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Audio(String nombre, int soundId, int idPersona,String autor) {
        this.soundId = soundId;
        this.nombre = nombre;
        this.idPersona = idPersona;
        this.autor = autor;
    }

    public int getSoundId() {

        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
