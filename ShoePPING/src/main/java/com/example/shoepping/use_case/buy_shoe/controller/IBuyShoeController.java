package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.pattern.observer.ShoeSizeList;

public interface IBuyShoeController {
    void onUpdate(ShoeSizeList shoeSizeList);
}
