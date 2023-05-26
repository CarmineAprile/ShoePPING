package com.example.shoepping.model.report;

import java.util.ArrayList;
import java.util.List;

public class ReportList implements IReportList{

    List<Report> reportAmount = new ArrayList<>();
    List<Report> reportPrice = new ArrayList<>();


    @Override
    public void addReportAmount(Report report) {
        this.reportAmount.add(report);
    }

    @Override
    public void addReportPrice(Report report) {
        this.reportPrice.add(report);
    }

    @Override
    public String toStringAmount(){
        StringBuilder sb = new StringBuilder();
        for (Report report : reportAmount){
            sb.append(report.toStringAmount());
        }

        return sb.toString();
    }

    @Override
    public String toStringPrice(){
        StringBuilder sb = new StringBuilder();
        for (Report report : reportPrice){
            sb.append(report.toStringPrice());
        }
        sb.append("\n------------------------------------------------------\n");
        return sb.toString();
    }
}
