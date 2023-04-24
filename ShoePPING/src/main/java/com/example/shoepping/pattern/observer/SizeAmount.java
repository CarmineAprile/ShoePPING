package com.example.shoepping.pattern.observer;

public class SizeAmount implements ISizeAmount{

    private final int shoeSize;

    private final int shoeAmount;

    public SizeAmount(int shoeSize, int shoeAmount) {
        this.shoeSize = shoeSize;
        this.shoeAmount = shoeAmount;
    }

    @Override
    public int getShoeSize() {
        return shoeSize;
    }

    @Override
    public int getShoeAmount() {
        return shoeAmount;
    }
}
