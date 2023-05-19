package com.example.shoepping.pattern.adapter;

import static jdk.internal.org.jline.utils.Log.error;

public class Adapter implements Target{

    @Override
    public double calculatePrice(String price, String condition) {

        double reccomendedPrice = Double.parseDouble(price);

        switch (condition){
            case "As new" -> reccomendedPrice = reccomendedPrice * 0.9;
            case "Lightly used" -> reccomendedPrice = reccomendedPrice * 0.7;
            case "Averagely used" -> reccomendedPrice = reccomendedPrice * 0.5;
            default -> error();
        }


        // arrotonda il valore a due cifre decimali
        return Math.round(reccomendedPrice * 100.0) / 100.0;

    }
}
