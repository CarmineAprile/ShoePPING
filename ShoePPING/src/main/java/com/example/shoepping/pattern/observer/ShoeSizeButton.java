package com.example.shoepping.pattern.observer;

public class ShoeSizeButton implements SizeButton{

    private boolean isAvailable = true;

    @Override
    public void update() {
        this.isAvailable = false;
    }

    @Override
    public boolean getIsAvailable() {
        return isAvailable;
    }


}
