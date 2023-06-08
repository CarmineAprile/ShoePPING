package com.example.shoepping;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class BarChartGController {
    @FXML
    BarChart<String,Integer> barchart;

    public void start(XYChart.Series<String, Integer> serie){
        barchart.getData().add(serie);
        barchart.setLegendVisible(false);

        //set first bar color
        for(Node n:barchart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: #F1CDD4;");
        }
        //second bar color
        for(Node n:barchart.lookupAll(".default-color1.chart-bar")) {
            n.setStyle("-fx-bar-fill: #554B4D;");
        }
    }
}
