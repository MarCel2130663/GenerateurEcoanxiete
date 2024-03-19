package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.Dechet;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Poubelle {

    @FXML
    ScrollPane scrollPoubelle;
    @FXML
    VBox vBox;
    @FXML
    Label nomDechet;
    @FXML
    ImageView imageView;
    @FXML
    Label tempsDesint;
    List<Dechet> listeBase = new ArrayList<>();
    List<Dechet> maPoubelle = new ArrayList<>();
    List<String> allLines;
    {
        try {
            allLines = Files.readAllLines(Paths.get("DechetsBase.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    List<String> poubelle;
    {
        try {
            poubelle = Files.readAllLines(Paths.get("PoubelleUtilisateur.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(){
        for (String allLine : allLines) {
            String[] infos = allLine.split(", ");
            if (!allLine.isEmpty()) {
                listeBase.add(new Dechet(infos[0], infos[1], infos[2], null));
            }
            else
                System.out.println("La liste de déchets prédéfinis est vide.");
        }
        for (String dechet : poubelle) {
            String[] infos = dechet.split(", ");
            if (!dechet.isEmpty()) {
                maPoubelle.add(new Dechet(infos[0], infos[1], infos[2], null));
            }
            else
                System.out.println("La poubelle est vide.");
        }
        if(!maPoubelle.isEmpty()){
            for(Dechet dechet : maPoubelle){
                for(Dechet dechetBase : listeBase){
                    if(dechet.getNom().equals(dechetBase.getNom())){
                        maPoubelle.add(new Dechet(dechet.getNom(), dechet.getTempsDesintegration(), dechet.getImageURL(), LocalDate.now()));
                    }
                }
            }
        }
        if(scrollPoubelle != null){
            scrollPoubelle.setContent(vBox);
        }
        for(Dechet dechet : maPoubelle){
            Button bouton = new Button(dechet.getNom());
            if(vBox != null){
                vBox.getChildren().add(bouton);
            }
            bouton.setOnAction(e -> {
                nomDechet.setText(dechet.getNom());
                imageView.setImage(new Image(dechet.getImageURL()));
                tempsDesint.setText(dechet.getTempsDesintegration());
            });
        }
    }

    public void voirGraphique() throws IOException {
        HelloApplication.changerScene("/graphique.fxml");
    }

    public void retourPoubelle() throws IOException {
        HelloApplication.changerScene("/listeDechets.fxml");
    }

    public void viderPoubelle(){
        //pop un avertissement
        poubelle.clear();
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

}
