package com.example.shoepping.model.report;

public interface IReportList {
    void addReportAmount(Report report);
    void addReportPrice(Report report);

    String toStringAmount();

    String toStringPrice();
}
