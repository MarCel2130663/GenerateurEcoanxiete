package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    ImageView imageView;

    @FXML
    public void initialize(){
        HelloApplication.setFond(borderPane);

        Bindings.bindBidirectional(distance.textProperty(), slider.valueProperty(), new NumberStringConverter());

        imageView.setImage(HelloApplication.images[(int) (Math.random() * 25)]);
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
