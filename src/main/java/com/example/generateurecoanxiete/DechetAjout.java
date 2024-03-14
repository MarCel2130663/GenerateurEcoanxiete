package com.example.generateurecoanxiete;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.util.Date;

public class DechetAjout {

    String nom;
    LocalDate date;

    public DechetAjout(String nom, LocalDate date){
        this.nom = nom;
        this.date = date;
    }

    public String getNom(){
        return nom;
    }

    public LocalDate getDate(){
        return date;
    }

    public String convertirCSV(){
        return nom + ", " + date + "\n";
    }

}
