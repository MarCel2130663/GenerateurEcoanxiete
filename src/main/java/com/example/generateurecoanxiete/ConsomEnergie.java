package com.example.generateurecoanxiete;

import java.util.Objects;

public class ConsomEnergie {

    public double heureMinSecEnSec(double heure, double minute, double seconde){
        return heure * 3600 + minute * 60 + seconde;
    }

    public String secEnHeureMinSec(double tempsAmpoule){
        int heure = 0;
        int minute = 0;
        int seconde;
        if(tempsAmpoule >= 3600){
            heure = (int) Math.floor(tempsAmpoule / 3600);
            if(tempsAmpoule % 3600 > 60){
                minute = (int) Math.floor((tempsAmpoule % 3600) / 60);
                seconde = (int) ((tempsAmpoule % 3600) / 60 - minute) * 60;
            }
            else{
                seconde = (int) tempsAmpoule;
            }
        }
        else if(tempsAmpoule >= 60){
            minute = (int) Math.floor(tempsAmpoule / 60);
            seconde = (int) ((tempsAmpoule % 3600) / 60 - minute) * 60;
        }
        else
            seconde = (int) tempsAmpoule;
        return heure + " h " + minute + " min " + seconde + " sec";
    }

    public double calculTempsAmpoule(double puissanceApp, double tempsAllum, String frequence){
        double energieConsommee = puissanceApp * tempsAllum;
        if(Objects.equals(frequence, "Une fois par jour"))
            return (energieConsommee / 60) * 365.25;
        else if(Objects.equals(frequence, "Une fois par semaine"))
            return (energieConsommee / 60) * 52.18;
        else if(Objects.equals(frequence, "Deux fois par semaine"))
            return (energieConsommee / 60) * 104.36;
        else if(Objects.equals(frequence, "Une fois par mois"))
            return (energieConsommee / 60) * 30.44;
        else if(Objects.equals(frequence, "Deux fois par mois"))
            return (energieConsommee / 60) * 68.88;
        else if(Objects.equals(frequence, "Deux fois par année"))
            return (energieConsommee / 60) * 2;
        else if(Objects.equals(frequence, "Trois fois par année"))
            return (energieConsommee / 60) * 3;
        else if(Objects.equals(frequence, "Quatre fois par année"))
            return (energieConsommee / 60) * 4;
        else
            return energieConsommee / 60;
    }



}
