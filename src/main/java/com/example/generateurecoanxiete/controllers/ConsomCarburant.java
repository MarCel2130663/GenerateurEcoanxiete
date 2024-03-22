package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.text.DecimalFormat;

public class ConsomCarburant {

    @FXML
    Slider slider;
    @FXML
    Label distance;
    @FXML
    Spinner<Integer> spinnerQuantCarb;
    @FXML
    Label reponseCarburant;
    DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    public void initialize(){
        Bindings.bindBidirectional(distance.textProperty(), slider.valueProperty(), new NumberStringConverter());
    }

    public String calculConsomCarb(int nbKm, int quantCarb){
        return df.format((float)(quantCarb * 100L) / nbKm);
    }

    public void trouverConsomCarb(){
        reponseCarburant.setText(calculConsomCarb((int) slider.getValue(), spinnerQuantCarb.getValue()));
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/deplacementArbres.fxml");
    }

}