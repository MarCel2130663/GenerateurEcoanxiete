package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.io.IOException;
import java.text.DecimalFormat;

public class DeplacementsEnArbres {

    @FXML
    Spinner<Integer> spinnerDist;

    @FXML
    Spinner<Integer> spinnerQuantCarb;

    @FXML
    Button trouverConsomCarb;
    @FXML
    Button menuDeplacement;
    @FXML
    Button menuCarburant;
    @FXML
    Button retour;
    @FXML
    Label reponse;

    DecimalFormat df = new DecimalFormat("0.00");

    public String calculConsomCarb(int nbKm, int quantCarb){
        return df.format((float)(quantCarb * 100L) / nbKm);
    }

    public void trouverConsomCarb(){
        reponse.setText(calculConsomCarb(spinnerDist.getValue(), spinnerQuantCarb.getValue()));
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/deplacementArbres.fxml");
    }

}
