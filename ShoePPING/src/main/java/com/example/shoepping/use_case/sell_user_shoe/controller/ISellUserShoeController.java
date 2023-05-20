package com.example.shoepping.use_case.sell_user_shoe.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface ISellUserShoeController {
    void onInsertSale(String brand, String item, String price, String condition, String size) throws IOException, SQLException, ClassNotFoundException;
    void onReccomendedPriceCalculate(String price, String condition);
}
