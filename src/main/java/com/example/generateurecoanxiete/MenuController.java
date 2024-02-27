package com.example.generateurecoanxiete;

import java.io.IOException;

public class MenuController {

    //Les fonctions a partir de la scene "accueil"
    public void menuMenuA() throws IOException{
        HelloApplication.changerScene("menu.fxml");
    }
    public void menuCredits() throws IOException{
        HelloApplication.changerScene("credits.fxml");
    }

    //Les fonctions a partir de la scene "menu"
    public void menuDeplacement() throws IOException{
        HelloApplication.changerScene("deplacementArbres.fxml");
    }

    public void menuSuiviDesDechets() throws IOException{
        //mettre le nom du fxml
        HelloApplication.changerScene(".fxml");
    }

    public void menuConsEnergie() throws IOException{
        HelloApplication.changerScene("consommationEnergie.fxml");
    }

    //Bouton pour retourner sur la scene "menu"
    public void menuMenu() throws IOException{
        HelloApplication.changerScene("menu.fxml");
    }

    //Bouton sur la scene "menu" pour retourner vers l'accueil
    public void menuAccueil() throws IOException{
        HelloApplication.changerScene("accueil.fxml");
    }

}
