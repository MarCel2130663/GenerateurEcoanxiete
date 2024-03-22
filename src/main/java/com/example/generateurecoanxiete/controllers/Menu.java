package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

public class Menu {

    @FXML
    BorderPane borderPane;

    @FXML
    public void initialize(){
        borderPane.setBackground(new Background(new BackgroundImage(new Image("file:accueilBG.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true))));
    }

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
