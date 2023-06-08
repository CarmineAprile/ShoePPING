package com.example.shoepping.pattern.observer;

import java.util.List;

public interface Observer {
    void update(List<SizeAmount> sizeAmounts);
}
