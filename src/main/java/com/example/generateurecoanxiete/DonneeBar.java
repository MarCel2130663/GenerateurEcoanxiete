package com.example.generateurecoanxiete;

import java.time.LocalDate;

public class DonneeBar {

    private LocalDate date;
    private int nombre;

    public DonneeBar(LocalDate date, int nombre){
        this.date = date;
        this.nombre = nombre;
    }

    public LocalDate getDate(){
        return date;
    }

    public int getNombre(){
        return nombre;
    }

    public void setNombre(int i){
        nombre = i;
    }

}
