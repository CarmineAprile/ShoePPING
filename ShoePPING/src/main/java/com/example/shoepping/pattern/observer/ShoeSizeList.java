package com.example.shoepping.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ShoeSizeList implements SizeList{
    public final List<SizeButton> buttons = new ArrayList<>();
    List<SizeAmount> sizeAmounts = new ArrayList<>();

    @Override
    public void addObserver(SizeButton button) {
        this.buttons.add(button);
    }

    @Override
    public void addSizeAmount(SizeAmount sizeAmount){
        this.sizeAmounts.add(sizeAmount);
    }

    @Override
    public void removeObserver(SizeButton button) {
        this.buttons.remove(button);
    }



    @Override
    public void setAvailable() {
        int i = 0;
        for (SizeButton button : this.buttons) {
            if(sizeAmounts.get(i).getShoeAmount() == 0){
                button.update();
            }
            i++;
        }
    }

}
