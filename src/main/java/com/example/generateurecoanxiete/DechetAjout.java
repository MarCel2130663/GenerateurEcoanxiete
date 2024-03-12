package com.example.generateurecoanxiete;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.util.Date;

public class DechetAjout {

    String nom;
    ImageView imageView;
    LocalDate date;

    public DechetAjout(String nom, ImageView imageView, LocalDate date){
        this.nom = nom;
        this.imageView = imageView;
        this.date = date;
    }

    public String getNom(){
        return nom;
    }

    public ImageView getImage(){
        return imageView;
    }

    public LocalDate getDate(){
        return date;
    }

}
