package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Accueil {

    public void menuAccueil() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void creditsAccueil() throws IOException {
        HelloApplication.changerScene("/credits.fxml");
    }

}
