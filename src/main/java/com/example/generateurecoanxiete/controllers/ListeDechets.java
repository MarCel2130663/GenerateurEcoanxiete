package com.example.generateurecoanxiete.controllers;

import com.example.generateurecoanxiete.objets.Dechet;
import com.example.generateurecoanxiete.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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

public class ListeDechets {

    @FXML
    BorderPane borderPane;
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
    ImageView imageView;
    List<CheckBox> listeCheckBoxes = new ArrayList<>();
    List<String> allLines;
    {
        try {
            allLines = Files.readAllLines(Paths.get("DechetsBase.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    List<Dechet> listeBase = new ArrayList<>();
    List<Dechet> poubelle = new ArrayList<>();

    public ListeDechets(){
    }

    public void initialize(){

        imageView.setImage(HelloApplication.images[(int) (Math.random() * 22)]);

        for (String allLine : allLines) {
            String[] infos = allLine.split(", ");
            if (!allLine.isEmpty()) {
                listeBase.add(new Dechet(infos[0], infos[1], Float.parseFloat(infos[2]), new Image(infos[3]), null));
            }
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

    public void ajouterPoubelle() throws IOException {
        FileWriter fw = new FileWriter("PoubelleUtilisateur.csv", true);
        poubelle.clear();
        listeCheckBoxes.stream().filter(CheckBox::isSelected).forEach(e -> {
            for(Dechet dechet : listeBase){
                if(dechet.getNom().equals(e.getText())){
                    poubelle.add(new Dechet(dechet.getNom(), dechet.getTempsDesintegration(), dechet.getMasse(), dechet.getImage(), LocalDate.now()));
                }
            }
        });
        for (Dechet dechet : poubelle) {
            try {
                fw.write(dechet.convertirCSV());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fw.flush();
        for(CheckBox checkBox : listeCheckBoxes){
            checkBox.setSelected(false);
        }
    }

    public void allerPoubelle() throws IOException {
        HelloApplication.changerScene("/poubelle.fxml");
    }

    public void menu() throws IOException {
        HelloApplication.changerScene("/menu.fxml");
    }

}
