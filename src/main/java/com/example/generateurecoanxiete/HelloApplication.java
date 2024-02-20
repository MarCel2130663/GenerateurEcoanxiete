package com.example.generateurecoanxiete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ConsomEnergie convertisseur = new ConsomEnergie();

        System.out.println(convertisseur.secEnHeureMinSec(109908));

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("energieConsomme.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}