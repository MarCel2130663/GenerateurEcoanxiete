package com.example.generateurecoanxiete.objets;

public class DonneePie {

    private String nom;
    private int nombre;

    public DonneePie(String nom, int nombre){
        this.nom = nom;
        this.nombre = nombre;
    }

    public String getNom(){
        return nom;
    }

    public int getNombre(){
        return nombre;
    }

    public void setNombre(int i){
        nombre = i;
    }


}
