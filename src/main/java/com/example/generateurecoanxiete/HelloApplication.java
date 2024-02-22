package com.example.generateurecoanxiete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ConsomEnergie convertEnergie = new ConsomEnergie();
        DeplacementsEnArbres convertArbres = new DeplacementsEnArbres();

        System.out.println("Temps durant lequel une ampoule de 60 W restera allumee (sec) : " + convertEnergie.calculTempsAmpoule(75, convertEnergie.heureMinSecEnSec(0, 15, 15), "Deux fois par jour"));
        System.out.println("Temps durant lequel une ampoule de 60 W restera allumee : " +
                convertEnergie.secEnHeureMinSec(convertEnergie.calculTempsAmpoule(120, convertEnergie.heureMinSecEnSec(0, 15, 40), "Deux fois par jour")));

        System.out.println("Consommation de carburant (L/100km) : " + convertArbres.calculConsomCarb(60, 4));

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("energieConsomme.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}