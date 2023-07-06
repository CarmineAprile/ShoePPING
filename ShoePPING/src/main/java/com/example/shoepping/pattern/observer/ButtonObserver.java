package com.example.shoepping.pattern.observer;

import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;

import java.util.List;

public class ButtonObserver implements Observer {

    private final int sizeButton;
    private final ShoeSizeSubject shoeSizeSubject;

    public ButtonObserver(int sizeButton, ShoeSizeSubject shoeSizeList) {
        this.sizeButton = sizeButton;
        this.shoeSizeSubject = shoeSizeList;
    }

    @Override
    public void update() {

        List<SizeAmount> observerState = shoeSizeSubject.getState();

        for(SizeAmount sa : observerState){
            if (sa.getShoeAmount() == 0 && sa.getShoeSize() == sizeButton) {
                IBuyShoeController buyShoeController = new BuyShoeController();
                buyShoeController.onUpdate(sizeButton);
                break;
            }
        }

    }

}
