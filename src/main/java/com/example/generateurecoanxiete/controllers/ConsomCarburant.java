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

public class ConsomCarburant {

    @FXML
    BorderPane borderPane;
    @FXML
    Slider slider;
    @FXML
    Label distance;
    @FXML
    Spinner<Integer> spinnerQuantCarb;
    @FXML
    Label reponseCarburant;
    @FXML
    ImageView imageView;
    DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    public void initialize(){
        imageView.setImage(HelloApplication.images[(int) (Math.random() * 22)]);
        Bindings.bindBidirectional(distance.textProperty(), slider.valueProperty(), new NumberStringConverter());
    }

    public String calculConsomCarb(int nbKm, int quantCarb){
        return df.format((float)(quantCarb * 100L) / nbKm);
    }

    public void trouver(){
        reponseCarburant.setText(calculConsomCarb((int) slider.getValue(), spinnerQuantCarb.getValue()));
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/deplacementArbres.fxml");
    }

}
