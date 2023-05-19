package com.example.shoepping.model.sale;

public interface ISale {
    String getBrand();
    String getItem();
    String getPrice();
    String getCondition();
    String getSize();

    int isValid();

    int isValidRecommendedPrice();
}
