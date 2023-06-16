package com.example.shoepping.pattern.observer;

public interface Subject {
    void addObserver(Observer observer);

    void addSizeAmount(SizeAmount sizeAmount);

    void removeObserver(Observer observer);

    void notifyObserver();
}
