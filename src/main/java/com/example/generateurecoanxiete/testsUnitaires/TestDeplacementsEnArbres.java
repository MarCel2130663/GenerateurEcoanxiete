package com.example.generateurecoanxiete.testsUnitaires;

import com.example.generateurecoanxiete.controllers.DeplacementsEnArbres;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeplacementsEnArbres {

    DeplacementsEnArbres testArbres = new DeplacementsEnArbres();

    @Test
    public void consomCarbTest(){
        assertEquals(testArbres.calculConsomCarb(40, 5), "12,50");
        assertEquals(testArbres.calculConsomCarb(70, 6), "8,57");
        assertEquals(testArbres.calculConsomCarb(100, 10), "10,00");
    }

}
