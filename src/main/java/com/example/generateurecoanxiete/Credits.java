package com.example.generateurecoanxiete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Credits {

    @FXML
    Button accueil;

    public void accueil() throws IOException {
        HelloApplication.changerScene("/accueil.fxml");
    }

}
