package com.example.shoepping.model.report;

public interface IReport {
    int getIdReport();

    int getSizeReport();

    int getAmountReport();

    String getModelReport();

    double getPriceReport();

    String toStringPrice();

    String toStringAmount();
}
