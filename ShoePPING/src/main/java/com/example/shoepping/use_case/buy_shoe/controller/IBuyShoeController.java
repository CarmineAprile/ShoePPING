package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.ShoeSizeList;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyShoeController {
    void onUpdate(ShoeSizeList shoeSizeList);

    void onConfirm(User user, boolean isChecked, String model, String price, String size, String address, String cardID, String cardDate, String cardCVC) throws SQLException, IOException, ClassNotFoundException;
}