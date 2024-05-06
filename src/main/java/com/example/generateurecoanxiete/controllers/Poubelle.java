package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.objets.Dechet;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

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
                maPoubelle.add(new Dechet(infos[0], infos[1], new Image(infos[2]), LocalDate.now()));
            }
            else
                System.out.println("La poubelle est vide.");
        }
        for(Dechet dechet : maPoubelle){
            Button bouton = new Button(dechet.getNom());
            if(vBox != null){
                vBox.getChildren().add(bouton);
                bouton.setPrefSize(390, 50);
                bouton.setStyle("-fx-font-size:20; -fx-background-color: #f2ccd4; -fx-text-fill: #895b65; -fx-background-radius: 60");
                bouton.setFont(Font.font("Trebuchet MS"));
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
        //pop un avertissement
        Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("Attention!");
        alerte.setHeaderText("Si vous videz votre poubelle, les données seront supprimées définitevement.");
        alerte.setContentText("Il vous sera impossible de les récupérer. Êtes-vous certain(e) de vouloir tout effacer?");
        ButtonType resultat = alerte.showAndWait().get();
        if(resultat == ButtonType.OK){
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
