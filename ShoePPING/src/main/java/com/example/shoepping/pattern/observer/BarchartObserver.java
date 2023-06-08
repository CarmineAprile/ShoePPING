package com.example.shoepping.pattern.observer;

import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import javafx.scene.chart.XYChart;

import java.util.List;

public class BarchartObserver implements Observer{

    private final IBuyShoeView buyShoeView;

    public BarchartObserver(IBuyShoeView buyShoeView) {
        this.buyShoeView = buyShoeView;
    }

    @Override
    public void update(List<SizeAmount> sizeAmounts) {

        XYChart.Series<String,Integer> serieLocal = new XYChart.Series<>();
        serieLocal.setName("Availability");
        for(SizeAmount sizeAmount: sizeAmounts){
            serieLocal.getData().add(new XYChart.Data<>(String.valueOf(sizeAmount.getShoeSize()), sizeAmount.getShoeAmount()));
        }

        IBuyShoeController buyShoeController = new BuyShoeController(buyShoeView);
        buyShoeController.onBarchart(serieLocal);

    }
}
