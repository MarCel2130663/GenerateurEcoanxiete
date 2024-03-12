package com.example.generateurecoanxiete;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.Date;

public class DechetAjout {

    String nom;
    Image image;
    LocalDate date;

    DechetAjout(String nom, Image image, LocalDate date){
        this.nom = nom;
        this.image = image;
        this.date = date;
    }

    public String getNom(){
        return nom;
    }

    public Image getImage(){
        return image;
    }

    public LocalDate getDate(){
        return date;
    }

}
