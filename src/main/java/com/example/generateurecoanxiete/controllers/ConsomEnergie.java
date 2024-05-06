package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.util.Objects;

public class ConsomEnergie {

    @FXML
    Slider slider;
    @FXML
    Label puissance;
    @FXML
    Spinner<Integer> spinnerH;
    @FXML
    Spinner<Integer> spinnerMin;
    @FXML
    Spinner<Integer> spinnerSec;
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    Label reponse;
    @FXML
    BorderPane borderPane;
    @FXML
    ImageView imageView;

    @FXML
    public void initialize(){
        Bindings.bindBidirectional(puissance.textProperty(), slider.valueProperty(), new NumberStringConverter());
        imageView.setImage(HelloApplication.images[(int) (Math.random() * 22)]);
    }

    public double heureMinSecEnSec(int heure, int minute, int seconde){
        return heure * 3600 + minute * 60 + seconde;
    }

    public String secEnHeureMinSec(double tempsAmpoule){
        long heure = 0;
        long minute = 0;
        long seconde;
        if(tempsAmpoule >= 3600){
            heure = (long) (tempsAmpoule / 3600);
            if(tempsAmpoule % 3600 > 60){
                minute = (long) Math.floor((tempsAmpoule % 3600) / 60);
                seconde = Math.round(((tempsAmpoule % 3600) / 60 - minute) * 60);
            }
            else{
                seconde = Math.round(tempsAmpoule % 3600);
            }
        }
        else if(tempsAmpoule >= 60){
            minute = (long) Math.floor(tempsAmpoule / 60);
            seconde = Math.round(((tempsAmpoule % 3600) / 60 - minute) * 60);
        }
        else seconde = Math.round(tempsAmpoule);
        return heure + " h " + minute + " min " + seconde + " sec";
    }

    public double calculTempsAmpoule(int puissanceApp, double tempsAllum, String frequence){
        double energieConsommee = puissanceApp * tempsAllum;
        if(Objects.equals(frequence, "Une fois par jour"))
            return ((energieConsommee / 60) * 365.25);
        else if(Objects.equals(frequence, "Deux fois par jour"))
            return ((energieConsommee / 60) * 730.5);
        else if(Objects.equals(frequence, "Une fois par semaine"))
            return ((energieConsommee / 60) * 52.18);
        else if(Objects.equals(frequence, "Deux fois par semaine"))
            return ((energieConsommee / 60) * 104.36);
        else if(Objects.equals(frequence, "Une fois par mois"))
            return ((energieConsommee / 60) * 12);
        else if(Objects.equals(frequence, "Deux fois par mois"))
            return ((energieConsommee / 60) * 24);
        else if(Objects.equals(frequence, "Deux fois par année"))
            return ((energieConsommee / 60) * 2);
        else if(Objects.equals(frequence, "Trois fois par année"))
            return ((energieConsommee / 60) * 3);
        else if(Objects.equals(frequence, "Quatre fois par année"))
            return ((energieConsommee / 60) * 4);
        else
            return (energieConsommee / 60);
    }

    public void convertir(){
        reponse.setText(secEnHeureMinSec(calculTempsAmpoule((int) slider.getValue(), heureMinSecEnSec(spinnerH.getValue(), spinnerMin.getValue(), spinnerSec.getValue()), choiceBox.getValue())));
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

}
