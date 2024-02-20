package com.example.generateurecoanxiete;

import javafx.fxml.FXML;

import java.util.Objects;

public class ConsomEnergie {


    public long heureMinSecEnSec(long heure, long minute, long seconde){
        return heure * 3600 + minute * 60 + seconde;
    }

    public String secEnHeureMinSec(long tempsAmpoule){
        int heure = 0;
        int minute = 0;
        int seconde = 0;
        if(tempsAmpoule >= 3600){
            heure = (int) Math.floor(tempsAmpoule / 3600);
            if(tempsAmpoule % 3600 > 60){
                minute = (int) Math.floor((tempsAmpoule % 3600) / 60);
                seconde = (int) Math.round(((tempsAmpoule % 3600) / 60 - minute) * 60);
            }
            else{
                seconde = (int) tempsAmpoule % 3600;
            }
        }
        else if(tempsAmpoule >= 60){
            minute = (int) Math.floor(tempsAmpoule / 60);
            seconde = (int) ((tempsAmpoule % 3600) / 60 - minute) * 60;
        }
        else if(tempsAmpoule < 60)
            seconde = (int) tempsAmpoule;
        return heure + " h " + minute + " min " + seconde + " sec";
    }

    public long calculTempsAmpoule(long puissanceApp, long tempsAllum, String frequence){
        double energieConsommee = puissanceApp * tempsAllum;
        if(Objects.equals(frequence, "Une fois par jour"))
            return (long) ((energieConsommee / 60) * 365.25);
        else if(Objects.equals(frequence, "Deux fois par jour"))
            return (long) ((energieConsommee / 60) * 730.5);
        else if(Objects.equals(frequence, "Une fois par semaine"))
            return (long) ((energieConsommee / 60) * 52.18);
        else if(Objects.equals(frequence, "Deux fois par semaine"))
            return (long) ((energieConsommee / 60) * 104.36);
        else if(Objects.equals(frequence, "Une fois par mois"))
            return (long) ((energieConsommee / 60) * 30.44);
        else if(Objects.equals(frequence, "Deux fois par mois"))
            return (long) ((energieConsommee / 60) * 68.88);
        else if(Objects.equals(frequence, "Deux fois par année"))
            return (long) ((energieConsommee / 60) * 2);
        else if(Objects.equals(frequence, "Trois fois par année"))
            return (long) ((energieConsommee / 60) * 3);
        else if(Objects.equals(frequence, "Quatre fois par année"))
            return (long) ((energieConsommee / 60) * 4);
        else
            return (long) (energieConsommee / 60);
    }



}
