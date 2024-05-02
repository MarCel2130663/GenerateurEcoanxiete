package com.example.generateurecoanxiete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Image[] images = {new Image("file:1.jpg"), new Image("file:2.jpg"), new Image("file:3.jpg"), new Image("file:4.jpg"), new Image("file:5.jpg"), new Image("file:6.jpg"),
        new Image("file:7.jpg"), new Image("file:8.jpg"), new Image("file:9.jpg"), new Image("file:10.jpg"), new Image("file:11.jpg"), new Image("file:12.jpg"), new Image("file:13.jpg"),
        new Image("file:14.jpg"), new Image("file:15.jpg"), new Image("file:16.jpg"), new Image("file:1.jpg"), new Image("file:17.jpg"), new Image("file:18.jpg"), new Image("file:19.jpg"),
        new Image("file:20.jpg"), new Image("file:21.jpg"), new Image("file:22.jpg"), new Image("file:23.jpg"), new Image("file:24.jpg"), new Image("file:25.jpg"), new Image("file:26.jpg")};
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
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/poubelle.fxml"));
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