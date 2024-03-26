package com.example.generateurecoanxiete;

import java.time.LocalDate;

public class DonneeGraph {

    private LocalDate date;
    private int nombre;

    public DonneeGraph(LocalDate date, int nombre){
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
