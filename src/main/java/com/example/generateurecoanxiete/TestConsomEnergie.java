package com.example.generateurecoanxiete;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConsomEnergie {

    ConsomEnergie testEnergie = new ConsomEnergie();
    @Test
    public void consomEnergieTest(){
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(100, testEnergie.heureMinSecEnSec(0, 5, 30), "Une fois par jour")), ("55 h 48 min 7 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(75, testEnergie.heureMinSecEnSec(0, 15, 15), "Deux fois par jour")), ("232 h 5 min 9 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(50, testEnergie.heureMinSecEnSec(0, 50, 45), "Une fois par semaine")), ("36 h 46 min 46 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(25, testEnergie.heureMinSecEnSec(1, 20, 22), "Deux fois par semaine")), ("55 h 48 min 0 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(2, testEnergie.heureMinSecEnSec(1, 37, 54), "Une fois par mois")), ("55 h 48 min 0 sec"));
    }

}
