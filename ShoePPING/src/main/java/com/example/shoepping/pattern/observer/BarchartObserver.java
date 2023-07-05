package com.example.shoepping.pattern.observer;

import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import javafx.scene.chart.XYChart;

import java.util.List;

public class BarchartObserver implements Observer{

    private final IBuyShoeView buyShoeView;
    private final ShoeSizeSubject shoeSizeSubject;

    public BarchartObserver(IBuyShoeView buyShoeView, ShoeSizeSubject shoeSizeList) {
        this.buyShoeView = buyShoeView;
        this.shoeSizeSubject = shoeSizeList;
    }

    @Override
    public void update() {

        List<SizeAmount> observerState = shoeSizeSubject.getState();

        XYChart.Series<String,Integer> serieLocal = new XYChart.Series<>();
        serieLocal.setName("Availability");
        for(SizeAmount sizeAmount: observerState){
            serieLocal.getData().add(new XYChart.Data<>(String.valueOf(sizeAmount.getShoeSize()), sizeAmount.getShoeAmount()));
        }

        IBuyShoeController buyShoeController = new BuyShoeController(buyShoeView);
        buyShoeController.onBarchart(serieLocal);

    }
}
