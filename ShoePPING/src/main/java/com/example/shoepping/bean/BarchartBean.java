package com.example.shoepping.bean;

import javafx.scene.chart.BarChart;

public class BarchartBean {

    private BarChart<String,Integer> barchart;

    public BarchartBean() {
        // empty constructor
    }

    public BarChart<String,Integer> getBarchart() {
        return barchart;
    }

    public void setBarchart(BarChart<String,Integer> barchartInt) {
        this.barchart = barchartInt;
    }
}
