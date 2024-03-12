package com.example.generateurecoanxiete;

import javafx.scene.image.Image;

public class DechetBase {

    String nom;
    String tempsDesintegration;

    public DechetBase(String nom, String tempsDesintegration){
        this.nom = nom;
        this.tempsDesintegration = tempsDesintegration;
    }

    public String getNom(){
        return nom;
    }

    public String getTempsDesintegration(){
        return tempsDesintegration;
    }

}
