package com.example.shoepping.use_case.sell_user_shoe.controller;

public interface ISellUserShoeController {
    void onInsertSale(String brand, String item, String price, String condition, String size);
}
