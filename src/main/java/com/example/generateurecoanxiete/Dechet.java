package com.example.generateurecoanxiete;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Dechet {

    String nom;
    String tempsDesintegration;
    Image image;
    LocalDate date;

    public Dechet(String nom, String tempsDesintegration, Image image, LocalDate date){
        this.nom = nom;
        this.tempsDesintegration = tempsDesintegration;
        this.image = image;
        this.date = date;
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

    public LocalDate getDate(){
        return date;
    }

    public String convertirCSV(){
        return nom + ", " + tempsDesintegration + ", " + image.getUrl() + ", " + date + "\n";
    }


}
