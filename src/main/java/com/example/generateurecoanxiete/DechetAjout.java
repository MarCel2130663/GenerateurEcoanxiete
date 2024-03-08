package com.example.generateurecoanxiete;

import javafx.scene.image.Image;
import java.util.Date;

public class DechetAjout {

    String nom;
    Image image;
    Date date;

    DechetAjout(String nom, Image image, Date date){
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

    public Date getDate(){
        return date;
    }

}
