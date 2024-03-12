package com.example.generateurecoanxiete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Menu {

    @FXML
    Button deplacement;

    @FXML
    Button suiviDechets;

    @FXML
    Button consomEnergie;

    @FXML
    Button retour;

    public void deplacement() throws IOException {
        HelloApplication.changerScene("/deplacementsArbres.fxml");
    }

    public void suiviDechets() throws IOException {
        HelloApplication.changerScene("/listeDechets.fxml");
    }

    public void consomEnergie() throws IOException {
        HelloApplication.changerScene("/consommationEnergie.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/accueil.fxml");
    }

}
