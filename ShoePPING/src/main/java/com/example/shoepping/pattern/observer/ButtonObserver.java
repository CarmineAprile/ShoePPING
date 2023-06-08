package com.example.shoepping.pattern.observer;

import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;

import java.util.List;

public class ButtonObserver implements Observer {

    private final int sizeButton;
    private final IBuyShoeView buyShoeView;

    public ButtonObserver(int sizeButton, IBuyShoeView buyShoeView) {
        this.sizeButton = sizeButton;
        this.buyShoeView = buyShoeView;
    }

    @Override
    public void update(List<SizeAmount> sizeAmounts) {
        for(SizeAmount sa : sizeAmounts){
            if (sa.getShoeAmount() == 0 && sa.getShoeSize() == sizeButton) {
                IBuyShoeController buyShoeController = new BuyShoeController(buyShoeView);
                buyShoeController.onUpdate(sizeButton);
                break;
            }
        }

    }

}
