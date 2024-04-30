package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

public class Credits {

    @FXML
    BorderPane borderPane;

    public void retour() throws IOException {
        HelloApplication.changerScene("/accueil.fxml");
    }

}
