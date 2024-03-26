package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.Dechet;
import com.example.generateurecoanxiete.DonneeGraph;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Graphique {

    @FXML
    BorderPane borderPane;
    @FXML
    ChoiceBox choiceBox;
    @FXML
    BarChart barChart;
    @FXML
    CategoryAxis axeDate;
    @FXML
    NumberAxis axeNombre;
    XYChart.Series serie = new XYChart.Series();
    @FXML
    VBox dechetsAujourdhui;
    List<Dechet> maPoubelle = new ArrayList<>();
    List<String> poubelle;
    {
        try {
            poubelle = Files.readAllLines(Paths.get("PoubelleUtilisateur.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    List<DonneeGraph> donnees = new ArrayList<>();

    @FXML
    public void initialize(){
        borderPane.setBackground(new Background(new BackgroundImage(new Image("file:dechetsBG.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true))));

        for (String dechet : poubelle) {
            String[] infos = dechet.split(", ");
            if (!dechet.isEmpty()) {
                maPoubelle.add(new Dechet(infos[0], infos[1], new Image(infos[2]), LocalDate.parse(infos[3])));
            }
            else
                System.out.println("La poubelle est vide.");
        }

        for(Dechet dechet1 : maPoubelle){
            Label label = new Label(dechet1.getNom());
            label.setScaleX(1.3);
            label.setScaleY(1.3);
            label.setTextAlignment(TextAlignment.LEFT);
            //aligner texte
            if(dechetsAujourdhui != null) {
                dechetsAujourdhui.getChildren().add(label);
            }
        }

        //boucle sur nos dechets
        for (Dechet dechet2 : maPoubelle) {
            //bool pour savoir si on a deja ce dechet dans la liste du graph
            boolean estTrouve = false;
            if(donnees.isEmpty()) {
                donnees.add(new DonneeGraph(dechet2.getDate(), 0));
            }
            //boucle sur les dechetgraphs
            for (DonneeGraph donnee : donnees) {
                if (donnee.getDate().equals(dechet2.getDate())) {
                    donnee.setNombre(donnee.getNombre() + 1);
                    estTrouve = true;
                }

            }
            //si aucun dechet trouve dans listegraph on ajoute un nouvel element
            if(!estTrouve){
                donnees.add(new DonneeGraph(dechet2.getDate(), 1));
            }
        }

        if(choiceBox.getValue().equals("Semaine")){
            for(DonneeGraph donnee : donnees){
                serie.getData().add(new XYChart.Data<>(String.valueOf(donnee.getDate()), donnee.getNombre()));
            }
            barChart.getData().addAll(serie);
        }
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/poubelle.fxml");
    }

}
