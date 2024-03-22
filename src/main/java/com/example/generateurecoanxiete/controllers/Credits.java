package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

public class Credits {

    @FXML
    BorderPane borderPane;

    @FXML
    public void initialize(){
        borderPane.setBackground(new Background(new BackgroundImage(new Image("file:creditsBG.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true))));
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/accueil.fxml");
    }

}
