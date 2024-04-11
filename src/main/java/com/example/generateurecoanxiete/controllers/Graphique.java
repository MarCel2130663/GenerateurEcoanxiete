package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.Dechet;
import com.example.generateurecoanxiete.DonneeBar;
import com.example.generateurecoanxiete.DonneePie;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

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
    XYChart.Series serie1 = new XYChart.Series();
    @FXML
    PieChart pieChart;
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
    List<DonneeBar> donneesBar = new ArrayList<>();
    List<DonneePie> donneesPie = new ArrayList<>();
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

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
            if(dechet1.getDate().equals(LocalDate.now())){
                Label label = new Label(dechet1.getNom());
                label.setScaleX(1.3);
                label.setScaleY(1.3);
                label.setTextAlignment(TextAlignment.LEFT);
                //aligner texte
                if(dechetsAujourdhui != null) {
                    dechetsAujourdhui.getChildren().add(label);
                }
            }
        }

        //donnees bar chart
        for (Dechet dechet2 : maPoubelle) {
            //bool pour savoir si on a deja ce dechet dans la liste du graph
            boolean estTrouve = false;
            if(donneesBar.isEmpty()) {
                donneesBar.add(new DonneeBar(dechet2.getDate(), 0));
            }
            //boucle sur les dechetgraphs
            for (DonneeBar donnee1 : donneesBar) {
                if (donnee1.getDate().equals(dechet2.getDate())) {
                    donnee1.setNombre(donnee1.getNombre() + 1);
                    estTrouve = true;
                }

            }
            //si aucun dechet trouve dans listegraph on ajoute un nouvel element
            if(!estTrouve){
                donneesBar.add(new DonneeBar(dechet2.getDate(), 1));
            }
        }
        for(DonneeBar donnee : donneesBar){
            serie1.getData().add(new XYChart.Data<>(String.valueOf(donnee.getDate()), donnee.getNombre()));
        }
        barChart.getData().addAll(serie1);

        //donnees pie chart
        for (Dechet dechet3 : maPoubelle) {
            //bool pour savoir si on a deja ce dechet dans la liste du graph
            if(Objects.equals(dechet3.getDate(), LocalDate.now())){
                boolean estTrouve = false;
                if(donneesPie.isEmpty()) {
                    donneesPie.add(new DonneePie(dechet3.getNom(), 0));
                }
                //boucle sur les dechetgraphs
                for (DonneePie donnee2 : donneesPie) {
                    if (donnee2.getNom().equals(dechet3.getNom())) {
                        donnee2.setNombre(donnee2.getNombre() + 1);
                        estTrouve = true;
                    }

                }
                //si aucun dechet trouve dans listegraph on ajoute un nouvel element
                if(!estTrouve){
                    donneesPie.add(new DonneePie(dechet3.getNom(), 1));
                }
            }
        }
        for(DonneePie donnee3 : donneesPie){
            pieChartData.add(new PieChart.Data(donnee3.getNom(), donnee3.getNombre()));
        }
        pieChart.setData(pieChartData);

    }



    //lier avec la choice box
    //semaine: empiler les donnees du fichier dans un stack et pop les 7 dernieres.
    //mois: empiler les donnees du fichier dans un stack et pop les 30 dernieres.
    //annee: empiler les donnees du fichier dans un stack et pop les 365 dernieres.

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/poubelle.fxml");
    }

}
