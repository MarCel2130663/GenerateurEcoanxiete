package com.example.generateurecoanxiete.objets;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Dechet {

    String nom;
    String tempsDesintegration;
    float masse;
    Image image;
    LocalDate date;

    public Dechet(String nom, String tempsDesintegration, float masse, Image image, LocalDate date){
        this.nom = nom;
        this.tempsDesintegration = tempsDesintegration;
        this.masse = masse;
        this.image = image;
        this.date = date;
    }

    public String getNom(){
        return nom;
    }

    public String getTempsDesintegration(){
        return tempsDesintegration;
    }
    public float getMasse(){
        return masse;
    }

    public Image getImage(){
        return image;
    }

    public LocalDate getDate(){
        return date;
    }

    public String convertirCSV(){
        return nom + ", " + tempsDesintegration + ", " + masse + ", " + image.getUrl() + ", " + date + "\n";
    }


}
