package com.example.shoepping.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ShoeSizeSubject implements Subject {
    public final List<Observer> observers = new ArrayList<>();
    List<SizeAmount> sizeAmounts = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void addSizeAmount(SizeAmount sizeAmount){
        this.sizeAmounts.add(sizeAmount);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }



    @Override
    public void setAvailable() {

        for (Observer button : this.observers) {
            button.update(sizeAmounts);
        }
    }

}
