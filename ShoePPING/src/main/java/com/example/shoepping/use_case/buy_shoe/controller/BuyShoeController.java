package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.pattern.observer.ShoeSizeList;
import com.example.shoepping.pattern.observer.SizeButton;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;

public class BuyShoeController implements IBuyShoeController{

    IBuyShoeView buyShoeView;

    public BuyShoeController(IBuyShoeView buyShoeView) {
        this.buyShoeView = buyShoeView;
    }

    @Override
    public void onUpdate(ShoeSizeList shoeSizeList) {
        int i = 37;
        for (SizeButton button : shoeSizeList.buttons) {
            if(!button.getIsAvailable()){
                buyShoeView.onDisable(i);
            }
            i++;
        }
    }


}
