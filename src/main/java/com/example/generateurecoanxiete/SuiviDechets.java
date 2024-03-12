package com.example.generateurecoanxiete;

import javafx.scene.image.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuiviDechets {

    List<String> allLines;

    {
        try {
            allLines = Files.readAllLines(Paths.get("CSVDechetsBase"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<DechetBase> listeBase = new ArrayList<>();
    List<DechetAjout> poubelle = new ArrayList<>();
    LocalDate aujourdhui = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    SuiviDechets(){
        for (String allLine : allLines) {
            String[] infos = allLine.split(", ");
            if (!allLine.isEmpty()) {
                listeBase.add(new DechetBase(infos[0], infos[1], new Image(infos[2])));
                System.out.println(infos[0] + ", " + infos[1]);
            }
        }
    }

    public void ajouterPoubelle(DechetBase nouveauDechet){
        poubelle.add(new DechetAjout(nouveauDechet.getNom(), nouveauDechet.getImage(), aujourdhui));
    }

}
