package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.DechetAjout;
import com.example.generateurecoanxiete.DechetBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SuiviDechets {

    @FXML
    CheckBox aluminium;
    @FXML
    CheckBox ampoule;

    @FXML
    CheckBox bouteillePlastique;
    @FXML
    CheckBox briquet;
    @FXML
    CheckBox canette;
    @FXML
    CheckBox carton;
    @FXML
    CheckBox chewingGum;
    @FXML
    CheckBox cigarette;
    @FXML
    CheckBox conserve;
    @FXML
    CheckBox couche;
    @FXML
    CheckBox journal;
    @FXML
    CheckBox lait;
    @FXML
    CheckBox masque;
    @FXML
    CheckBox mouchoir;
    @FXML
    CheckBox papierBonbon;
    @FXML
    CheckBox pile;
    @FXML
    CheckBox pneu;
    @FXML
    CheckBox polystyrene;
    @FXML
    CheckBox sacPlastique;
    @FXML
    CheckBox servietteTampon;
    @FXML
    CheckBox verre;
    @FXML
    Button ajouterPoubelle;

    List<CheckBox> listeCheckBoxes = new ArrayList<>();

    List<String> allLines;

    {
        try {
            allLines = Files.readAllLines(Paths.get("DechetsBase.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<DechetBase> listeBase = new ArrayList<>();
    List<DechetAjout> poubelle = new ArrayList<>();
    LocalDate aujourdhui = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public void initialize(){
        for (String allLine : allLines) {
            String[] infos = allLine.split(", ");
            if (!allLine.isEmpty()) {
                listeBase.add(new DechetBase(infos[0], infos[1]));
            }
            else
                System.out.println("La liste de déchets prédéfinis est vide.");
        }
        listeCheckBoxes.add(aluminium);
        listeCheckBoxes.add(ampoule);
        listeCheckBoxes.add(bouteillePlastique);
        listeCheckBoxes.add(briquet);
        listeCheckBoxes.add(canette);
        listeCheckBoxes.add(carton);
        listeCheckBoxes.add(chewingGum);
        listeCheckBoxes.add(cigarette);
        listeCheckBoxes.add(conserve);
        listeCheckBoxes.add(couche);
        listeCheckBoxes.add(journal);
        listeCheckBoxes.add(lait);
        listeCheckBoxes.add(masque);
        listeCheckBoxes.add(mouchoir);
        listeCheckBoxes.add(papierBonbon);
        listeCheckBoxes.add(pile);
        listeCheckBoxes.add(pneu);
        listeCheckBoxes.add(polystyrene);
        listeCheckBoxes.add(sacPlastique);
        listeCheckBoxes.add(servietteTampon);
        listeCheckBoxes.add(verre);
    }

    public void ajouterPoubelle(){
        Stream<CheckBox> streamCB = listeCheckBoxes.stream();
        streamCB.filter(CheckBox::isSelected).forEach(e -> poubelle.add(new DechetAjout(e.getText(), new ImageView(), aujourdhui)));
        for (DechetAjout dechetAjout : poubelle) {
            System.out.println(dechetAjout.getNom());
            //ecrire dans fichier csv
        }
    }

}