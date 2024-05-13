package com.example.generateurecoanxiete.objets;

import java.time.LocalDate;

public class DonneeBar {

    private LocalDate date;
    private float masse;

    public DonneeBar(LocalDate date, float masse){
        this.date = date;
        this.masse = masse;
    }

    public LocalDate getDate(){
        return date;
    }

    public float getMasse(){
        return masse;
    }

    public void setMasse(float i){
        masse = i;
    }

}
