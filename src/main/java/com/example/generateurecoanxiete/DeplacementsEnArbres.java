package com.example.generateurecoanxiete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.text.DecimalFormat;

public class DeplacementsEnArbres {

    @FXML
    Spinner<Integer> spinnerDist;

    @FXML
    Spinner<Integer> spinnerQuantCarb;

    @FXML
    Button trouverConsomCarb;

    @FXML
    Label reponse;

    DecimalFormat df = new DecimalFormat("0.00");

    public String calculConsomCarb(int nbKm, int quantCarb){
        return df.format((float)(quantCarb * 100L) / nbKm);
    }

    public void trouverConsomCarb(){
        reponse.setText(calculConsomCarb(spinnerDist.getValue(), spinnerQuantCarb.getValue()));
    }

}
