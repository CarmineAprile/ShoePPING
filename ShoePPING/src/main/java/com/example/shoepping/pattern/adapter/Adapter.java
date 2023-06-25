package com.example.shoepping.pattern.adapter;

import com.example.shoepping.model.sale.Sale;

import static jdk.internal.org.jline.utils.Log.error;

public class Adapter implements Target{

    private final Sale sale;

    public Adapter(Sale sale){
        this.sale = sale;
    }

    @Override
    public double calculatePrice() {

        double reccomendedPrice = Double.parseDouble(this.sale.getPrice());

        switch (this.sale.getCondition()){
            case "As new" -> reccomendedPrice = reccomendedPrice * 0.9;
            case "Lightly used" -> reccomendedPrice = reccomendedPrice * 0.7;
            case "Averagely used" -> reccomendedPrice = reccomendedPrice * 0.5;
            default -> error();
        }


        // arrotonda il valore a due cifre decimali
        return Math.round(reccomendedPrice * 100.0) / 100.0;

    }
}
