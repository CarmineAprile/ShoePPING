package com.example.shoepping.model.report;

public class Report implements IReport {

    private final int idReport;
    private int sizeReport;
    private int amountReport;
    private String modelReport;
    private double priceReport;

    public Report(int idReport, int sizeReport, int amount){
        this.idReport = idReport;
        this.sizeReport = sizeReport;
        this.amountReport = amount;
    }

    public Report(int idReport, String modelReport, double priceReport){
        this.idReport = idReport;
        this.modelReport = modelReport;
        this.priceReport = priceReport;
    }

    @Override
    public int getIdReport() {
        return idReport;
    }
    @Override
    public int getSizeReport() {
        return sizeReport;
    }
    @Override
    public int getAmountReport() {
        return amountReport;
    }
    @Override
    public String getModelReport() {
        return modelReport;
    }
    @Override
    public double getPriceReport() {
        return priceReport;
    }

    @Override
    public String toStringPrice() {
        return getIdReport() + "\t" + getModelReport() + "\t" + getPriceReport() + "$" + "\n";
    }

    @Override
    public String toStringAmount() {
        return getIdReport() + "\t" + getSizeReport() + "\t" + getAmountReport() + "\n";
    }
}
