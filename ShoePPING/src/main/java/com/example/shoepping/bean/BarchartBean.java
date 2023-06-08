package com.example.shoepping.bean;

import javafx.scene.chart.XYChart;

public class BarchartBean {

    private XYChart.Series<String, Integer> barchart;

    public BarchartBean() {
        // empty constructor
    }

    public XYChart.Series<String, Integer> getBarchart() {
        return barchart;
    }

    public void setBarchart(XYChart.Series<String, Integer> barchartInt) {
        this.barchart = barchartInt;
    }
}
