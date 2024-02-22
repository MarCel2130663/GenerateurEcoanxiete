package com.example.generateurecoanxiete.testsUnitaires;

import com.example.generateurecoanxiete.ConsomEnergie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConsomEnergie {

    ConsomEnergie testEnergie = new ConsomEnergie();

    @Test
    public void heureMinSecEnSecTest(){
        assertEquals(testEnergie.heureMinSecEnSec(1, 30, 2), 5402, 1);
        assertEquals(testEnergie.heureMinSecEnSec(0, 10, 35), 635, 1);
        assertEquals(testEnergie.heureMinSecEnSec(2, 0, 13), 7213, 1);
        assertEquals(testEnergie.heureMinSecEnSec(1, 14, 0), 4440, 1);
        assertEquals(testEnergie.heureMinSecEnSec(0, 0, 45), 45, 1);
        assertEquals(testEnergie.heureMinSecEnSec(4, 0, 0), 14400, 1);
        assertEquals(testEnergie.heureMinSecEnSec(0, 7, 0), 420, 1);
        assertEquals(testEnergie.heureMinSecEnSec(0, 0, 0), 0, 1);
    }

    @Test
    public void secEnHeureMinSecTest(){
        assertEquals(testEnergie.secEnHeureMinSec(123456), "34 h 17 min 36 sec");
        assertEquals(testEnergie.secEnHeureMinSec(1500), "0 h 25 min 0 sec");
        assertEquals(testEnergie.secEnHeureMinSec(4), "0 h 0 min 4 sec");
        assertEquals(testEnergie.secEnHeureMinSec(0), "0 h 0 min 0 sec");
    }

    @Test
    public void calculTempsAmpouleTest(){
        assertEquals(testEnergie.calculTempsAmpoule(30, 60, "Aucune"), 30, 1);
        assertEquals(testEnergie.calculTempsAmpoule(50, 1200, "Deux fois par mois"), 24000, 1);
        assertEquals(testEnergie.calculTempsAmpoule(60, 10, "Une fois par semaine"), 521.8, 1);
    }

    @Test
    public void consomEnergieTest(){
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(0, testEnergie.heureMinSecEnSec(7, 59, 59), "Aucune")), ("0 h 0 min 0 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(100, testEnergie.heureMinSecEnSec(0, 0, 30), "Une fois par jour")), ("5 h 4 min 22 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(75, testEnergie.heureMinSecEnSec(0, 15, 15), "Deux fois par jour")), ("232 h 5 min 9 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(50, testEnergie.heureMinSecEnSec(0, 50, 45), "Une fois par semaine")), ("36 h 46 min 46 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(25, testEnergie.heureMinSecEnSec(1, 20, 22), "Deux fois par semaine")), ("58 h 14 min 36 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(2, testEnergie.heureMinSecEnSec(1, 37, 54), "Une fois par mois")), ("0 h 39 min 9 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(10, testEnergie.heureMinSecEnSec(3, 0, 23), "Deux fois par mois")), ("12 h 1 min 32 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(35, testEnergie.heureMinSecEnSec(2, 5, 0), "Deux fois par année")), ("2 h 25 min 50 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(85, testEnergie.heureMinSecEnSec(0, 0, 0), "Trois fois par année")), ("0 h 0 min 0 sec"));
        assertEquals(testEnergie.secEnHeureMinSec(testEnergie.calculTempsAmpoule(45, testEnergie.heureMinSecEnSec(1, 0, 0), "Quatre fois par année")), ("3 h 0 min 0 sec"));
    }

}
