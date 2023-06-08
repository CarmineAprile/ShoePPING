package com.example.shoepping.pattern.observer;

import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.List;

public class BarchartObserver implements Observer{

    BarChart<String,Integer> barchart;
    private final IBuyShoeView buyShoeView;

    public BarchartObserver(IBuyShoeView buyShoeView) {
        this.buyShoeView = buyShoeView;
    }

    @Override
    public void update(List<SizeAmount> sizeAmounts) {
        barchart.setLegendVisible(false);
        XYChart.Series<String,Integer> serie = new XYChart.Series<>();

        serie.setName("Availability");
        for(SizeAmount sizeAmount: sizeAmounts){
            serie.getData().add(new XYChart.Data<>(String.valueOf(sizeAmount.getShoeSize()), sizeAmount.getShoeAmount()));
        }
        barchart.getData().add(serie);

        //set first bar color
        for(Node n:barchart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: #F1CDD4;");
        }
        //second bar color
        for(Node n:barchart.lookupAll(".default-color1.chart-bar")) {
            n.setStyle("-fx-bar-fill: #554B4D;");
        }
        IBuyShoeController buyShoeController = new BuyShoeController(buyShoeView);
        buyShoeController.onBarchart(barchart);
    }
}
