package com.example.generateurecoanxiete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {

    private static Stage stage;
    public static void changerScene(String nouvelleScene) throws IOException {
    FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource(nouvelleScene));
    Scene scene = new Scene(root.load(), 500, 750);
    stage.setScene(scene);
}
    @Override
    public void start(Stage stage) throws IOException {

        HelloApplication.stage = stage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/consommationEnergie.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 811, 1062);
            stage.setTitle("Generateur d'ecoanxiete");
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