package com.example.shoepping.pattern.observer;

public interface SizeList {
    void addObserver(SizeButton button);

    void addSizeAmount(SizeAmount sizeAmount);

    void removeObserver(SizeButton button);

    void setAvailable();
}
