package com.example.generateurecoanxiete.testsUnitaires;

import com.example.generateurecoanxiete.controllers.DeplacementArbres;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeplacementArbres {

    DeplacementArbres testDepArbres = new DeplacementArbres();

    @Test
    public void testDeplacementArbres(){

        assertEquals(testDepArbres.calculEmission(8, 3000), 4, 0);
        assertEquals(testDepArbres.calculEmission(5, 20), 0, 0);
        assertEquals(testDepArbres.calculEmission(15, 2145), 5, 0);

    }

}
