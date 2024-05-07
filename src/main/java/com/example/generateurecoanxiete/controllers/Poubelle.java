package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.objets.Dechet;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Poubelle {

    @FXML
    BorderPane borderPane;
    @FXML
    ScrollPane scrollPoubelle;
    @FXML
    VBox vBox;
    @FXML
    Label nomDechet;
    @FXML
    ImageView imageView;
    @FXML
    StackPane stackPane;
    List<Dechet> maPoubelle = new ArrayList<>();
    List<String> poubelleUtilisateur;
    {
        try {
            poubelleUtilisateur = Files.readAllLines(Paths.get("PoubelleUtilisateur.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(){

        for (String dechet : poubelleUtilisateur) {
            String[] infos = dechet.split(", ");
            if (!dechet.isEmpty()) {
                maPoubelle.add(new Dechet(infos[0], infos[1], Float.parseFloat(infos[2]), new Image(infos[3]), LocalDate.now()));
            }
            else
                System.out.println("La poubelle est vide.");
        }
        for(Dechet dechet : maPoubelle){
            Button bouton = new Button(dechet.getNom());
            if(vBox != null){
                vBox.getChildren().add(bouton);
                bouton.setPrefSize(390, 50);
                bouton.setStyle("-fx-font-size:20; -fx-background-color: #f2ccd4; -fx-text-fill: #895b65; -fx-font-family: 'Trebuchet MS'; -fx-background-radius: 60");
            }
            bouton.setOnAction(e -> {
                stackPane.getChildren().clear();
                nomDechet.setText(dechet.getNom() + " ~ " + dechet.getTempsDesintegration());
                imageView.setImage(new Image(dechet.getImage().getUrl(), 1000, 1000, false, false));
                stackPane.getChildren().add(imageView);
            });
        }
    }

    public void voirGraphique() throws IOException {
        HelloApplication.changerScene("/graphique.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/listeDechets.fxml");
    }

    public void viderPoubelle() throws IOException {
        Label header = new Label("Si vous videz votre poubelle, les données seront supprimées définitivement.\nIl vous sera alors impossible de les récupérer.");
        Label content = new Label("Êtes-vous certain(e) de vouloir tout effacer?");
        DialogPane dialogPane = new DialogPane();
        dialogPane.setStyle("-fx-background: #895b65");
        dialogPane.setPadding(new Insets(20));
        dialogPane.setHeader(header);
        dialogPane.setContent(content);
        dialogPane.getHeader().setStyle("-fx-text-fill: #f2ccd4; -fx-font-size: 20; -fx-font-family: 'Trebuchet MS'");
        dialogPane.getContent().setStyle("-fx-text-fill: #f2ccd4; -fx-font-size: 14; -fx-font-family: 'Trebuchet MS'");
        dialogPane.getButtonTypes().add(ButtonType.YES);
        dialogPane.getButtonTypes().add(ButtonType.CANCEL);
        dialogPane.lookupButton(ButtonType.YES).setStyle("-fx-font-size:20; -fx-background-color: #cf8fa1; -fx-text-fill: #f2ccd4; -fx-font-family: 'Trebuchet MS'; -fx-background-radius: 60");
        dialogPane.lookupButton(ButtonType.CANCEL).setStyle("-fx-font-size: 20; -fx-background-color: #cf8fa1; -fx-text-fill: #f2ccd4; -fx-font-family: 'Trebuchet MS'; -fx-background-radius: 60");
        Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("Attention!");
        alerte.setDialogPane(dialogPane);
        ButtonType resultat = alerte.showAndWait().get();
        if(resultat == ButtonType.YES){
            vBox.getChildren().clear();
            poubelleUtilisateur.clear();
            FileWriter fw = new FileWriter("PoubelleUtilisateur.csv", false);
            fw.write("");
        }
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

}
