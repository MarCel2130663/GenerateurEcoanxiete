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
    NumberAxis axeMasse = new NumberAxis();
    @FXML
    BarChart<String, Number> barChart = new BarChart<>(axeDate, axeMasse);
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
                maPoubelle.add(new Dechet(infos[0], infos[1], Float.parseFloat(infos[2]), new Image(infos[3]), LocalDate.parse(infos[4])));
            }
        }

        //scrollpane
        for(Dechet dechet1 : maPoubelle){
            if(dechet1.getDate().equals(LocalDate.now())){
                Label label = new Label(dechet1.getNom());
                label.setStyle("-fx-font-size:20; -fx-text-fill: #d0c498");
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
            for (DonneeBar donneeBar : donneesBar) {
                if (donneeBar.getDate().equals(dechet2.getDate())) {
                    donneeBar.setMasse(donneeBar.getMasse() + dechet2.getMasse());
                    estTrouve = true;
                }
            }
            //si aucun dechet trouve dans listegraph on ajoute un nouvel element
            if(!estTrouve){
                donneesBar.add(new DonneeBar(dechet2.getDate(), dechet2.getMasse()));
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
        XYChart.Series serie = new XYChart.Series();
        int j = 0;

        if(choiceBox.getValue().equals("Semaine")){
            j = 7;
        }
        else if(choiceBox.getValue().equals("Mois")){
            j = 30;
        }
        else if(choiceBox.getValue().equals("Année")){
            j = 365;
        }
        //si pas de donnee aujourd'hui ou pile vide
        if(!Objects.equals(stack.peek().getDate(), LocalDate.now()) || stack.isEmpty()){
            stack.add(new DonneeBar(LocalDate.now(), 0));
        }
        //faire tant que pile plus petite que j
        do{
            DonneeBar a = stack.pop();
            if (!stack.isEmpty()){
                DonneeBar b = stack.peek();
                //si a et b pas consecutifs
                if(ChronoUnit.DAYS.between(b.getDate(), a.getDate()) != 1){
                    stack.add(new DonneeBar(a.getDate().minusDays(1), 0));
                    stack.add(a);
                }
                else
                    stack2.add(a);
            }
            //si pas assez de donnees ajouter la premiere journee affichee
            else{
                stack.add(new DonneeBar(a.getDate().minusDays(j - stack2.size() - 1), 0));
                stack.add(a);
            }
        }while(stack2.size() < j);

        for(int i = 0; i < j; i++){
            if(!stack2.isEmpty()){
                DonneeBar c = stack2.pop();
                System.out.println(c.getDate() + " : " + c.getMasse());
                serie.getData().addAll(new XYChart.Data(String.valueOf(c.getDate()), c.getMasse()));
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
