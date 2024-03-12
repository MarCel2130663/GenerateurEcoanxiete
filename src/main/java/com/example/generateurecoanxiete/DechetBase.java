package com.example.generateurecoanxiete;

import javafx.scene.image.Image;

public class DechetBase {

    String nom;
    String tempsDesintegration;
    Image image;

    public DechetBase(String nom, String tempsDesintegration, Image image){
        this.nom = nom;
        this.tempsDesintegration = tempsDesintegration;
        this.image = image;
    }

    public String getNom(){
        return nom;
    }

    public String getTempsDesintegration(){
        return tempsDesintegration;
    }

    public Image getImage(){
        return image;
    }

}
