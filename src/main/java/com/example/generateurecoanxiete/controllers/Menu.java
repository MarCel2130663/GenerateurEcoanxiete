package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Menu {

    public void deplacement() throws IOException {
        HelloApplication.changerScene("/deplacementArbres.fxml");
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
