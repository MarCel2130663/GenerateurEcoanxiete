package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.text.DecimalFormat;

public class DeplacementsEnArbres {

    @FXML
    BorderPane borderPane;
    @FXML
    Spinner spinner;
    @FXML
    Slider slider;
    @FXML
    Label distance;
    @FXML
    Label reponseDeplacement;

    @FXML
    public void initialize(){
        borderPane.setBackground(new Background(new BackgroundImage(new Image("file:depArbresBG.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true))));

        Bindings.bindBidirectional(distance.textProperty(), slider.valueProperty(), new NumberStringConverter());
    }

    public void jncpmcdc() throws IOException {
        HelloApplication.changerScene("/consommationCarburant.fxml");
    }

    public int calculEmission(int consomCarburant, int distance){
        return (int) Math.round(((((consomCarburant * 2.392) / 100) * distance) / 140));
    }

    public void convertir(){
        reponseDeplacement.setText(String.valueOf(calculEmission((int)spinner.getValue(), (int)slider.getValue())));
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

}
