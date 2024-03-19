package com.example.generateurecoanxiete;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Dechet {

    String nom;
    String tempsDesintegration;
    String imageURL;
    LocalDate date;

    public Dechet(String nom, String tempsDesintegration, String imageURL, LocalDate date){
        this.nom = nom;
        this.tempsDesintegration = tempsDesintegration;
        this.imageURL = imageURL;
        this.date = date;
    }

    public String getNom(){
        return nom;
    }

    public String getTempsDesintegration(){
        return tempsDesintegration;
    }

    public String getImageURL(){
        return imageURL;
    }

    public LocalDate getDate(){
        return date;
    }

    public String convertirCSV(){
        return nom + ", " + tempsDesintegration + ", " + imageURL + ", " + date + "\n";
    }


}
