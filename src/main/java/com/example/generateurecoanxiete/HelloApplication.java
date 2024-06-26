package com.example.generateurecoanxiete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Image[] images = {new Image("file:1.png"), new Image("file:2.png"), new Image("file:3.png"), new Image("file:4.png"), new Image("file:5.png"), new Image("file:6.png"),
        new Image("file:7.png"), new Image("file:8.png"), new Image("file:9.png"), new Image("file:10.png"), new Image("file:11.png"), new Image("file:12.png"), new Image("file:13.png"),
        new Image("file:14.png"), new Image("file:15.png"), new Image("file:16.png"), new Image("file:17.png"), new Image("file:18.png"), new Image("file:19.png"),
        new Image("file:20.png"), new Image("file:21.png"), new Image("file:22.png"), new Image("file:23.png")};
    private static Stage stage;
    public static void changerScene(String nouvelleScene) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource(nouvelleScene));
        Scene scene = new Scene(root.load(), 1500, 800);
        stage.setScene(scene);
    }

    @Override
    public void start(Stage stage){

        HelloApplication.stage = stage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/accueil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1500, 800);
            stage.setTitle("Générateur d'écoanxiété");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}