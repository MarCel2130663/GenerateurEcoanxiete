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

public class DeplacementsEnArbres {

    @FXML
    Slider slider;
    @FXML
    Label distance;
    @FXML
    Label reponseDeplacement;

    DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    public void initialize(){
        Bindings.bindBidirectional(distance.textProperty(), slider.valueProperty(), new NumberStringConverter());
    }

    public void jncpmcdc() throws IOException {
        HelloApplication.changerScene("/consommationCarburant.fxml");
    }

    public void convertir(){
        //calculs
        reponseDeplacement.setText(String.valueOf((int)3.010));
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

}
