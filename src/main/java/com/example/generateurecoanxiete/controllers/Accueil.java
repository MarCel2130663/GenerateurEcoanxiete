package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.layout.*;

import java.io.IOException;

public class Accueil {

    @FXML
    BorderPane borderPane;

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void credits() throws IOException {
        HelloApplication.changerScene("/credits.fxml");
    }

}
