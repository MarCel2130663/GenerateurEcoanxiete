package com.example.generateurecoanxiete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Accueil {

    @FXML
    Button menuAccueil;

    @FXML
    Button creditsAccueil;

    public void menuAccueil() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void creditsAccueil() throws IOException {
        HelloApplication.changerScene("/credits.fxml");
    }

}
