package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.objets.Dechet;
import com.example.generateurecoanxiete.objets.DonneeBar;
import com.example.generateurecoanxiete.objets.DonneePie;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Graphique {

    @FXML
    BorderPane borderPane;
    @FXML
    ChoiceBox choiceBox;
    @FXML
    CategoryAxis axeDate = new CategoryAxis();
    @FXML
    NumberAxis axeNombre = new NumberAxis();
    @FXML
    BarChart<String, Number> barChart = new BarChart<>(axeDate, axeNombre);
    @FXML
    PieChart pieChart;
    @FXML
    VBox dechetsAujourdhui;
    List<Dechet> maPoubelle = new ArrayList<>();
    List<String> poubelleUtilisateur;
    {
        try {
            poubelleUtilisateur = Files.readAllLines(Paths.get("PoubelleUtilisateur.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    List<DonneeBar> donneesBar = new ArrayList<>();
    List<DonneePie> donneesPie = new ArrayList<>();
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    @FXML
    public void initialize(){

        for (String dechet : poubelleUtilisateur) {
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

    public void choiceBoxOnAction(){
        barChart.getData().clear();
        Stack<DonneeBar> stack = new Stack<>();
        stack.addAll(donneesBar);
        Stack<DonneeBar> stack2 = new Stack<>();
        List<XYChart.Data> listeFinale = new ArrayList<>();
        XYChart.Series serie = new XYChart.Series();
        int j = 0;

        if(!stack.isEmpty()){
            if(!Objects.equals(stack.peek().getDate(), LocalDate.now())){
                stack.add(new DonneeBar(LocalDate.now(), 0));
            }
        }

        if(choiceBox.getValue().equals("Semaine")){
            j = 7;
        }
        else if(choiceBox.getValue().equals("Mois")){
            j = 30;
        }
        else if(choiceBox.getValue().equals("Année")){
            j = 365;
        }

        for(int i = 0; i < j; i++){
            if(!stack.isEmpty()){
                DonneeBar a = stack.pop();
                if (!stack.isEmpty()){
                    DonneeBar b = stack.peek();
                    if(ChronoUnit.DAYS.between(b.getDate(), a.getDate()) != 1){
                        stack.add(new DonneeBar(a.getDate().minusDays(1), 0));
                    }
                    stack2.add(a);
                }
                else{
                    stack2.add(a);
                    stack.add(new DonneeBar(stack2.peek().getDate().minusDays(j - i), 0));
                    stack.add(new DonneeBar(stack2.peek().getDate().minusDays(j - i + 1), 0));
                }
            }
            else{
                stack2.add(new DonneeBar(LocalDate.now(), 0));
                stack.add(new DonneeBar(stack2.peek().getDate().minusDays(j - i), 0));
                stack.add(new DonneeBar(stack2.peek().getDate().minusDays(j - i + 1), 0));
            }
        }
        for(int i = 0; i < j; i++){
            if(!stack2.isEmpty()){
                DonneeBar c = stack2.pop();
                serie.getData().addAll(new XYChart.Data(String.valueOf(c.getDate()), c.getNombre()));
            }
        }
        barChart.getData().addAll(serie);
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

    public void retour() throws IOException {
        HelloApplication.changerScene("/poubelle.fxml");
    }

}
