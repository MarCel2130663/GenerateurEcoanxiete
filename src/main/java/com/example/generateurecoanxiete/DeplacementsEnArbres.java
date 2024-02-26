package com.example.generateurecoanxiete;

import java.text.DecimalFormat;

public class DeplacementsEnArbres {

    DecimalFormat df = new DecimalFormat("0.00");

    public String calculConsomCarb(double nbKm, double quantCarb){
        return df.format((quantCarb * 100) / nbKm);
    }

}
