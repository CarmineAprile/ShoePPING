package com.example.shoepping.pattern.observer;

public class SizeAmount implements ISizeAmount{

    private final int ShoeSize;

    private final int ShoeAmount;

    public SizeAmount(int shoeSize, int shoeAmount) {
        ShoeSize = shoeSize;
        ShoeAmount = shoeAmount;
    }

    @Override
    public int getShoeSize() {
        return ShoeSize;
    }

    @Override
    public int getShoeAmount() {
        return ShoeAmount;
    }
}
