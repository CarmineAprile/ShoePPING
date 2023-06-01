package com.example.shoepping.use_case.sell_user_shoe.controller;

import com.example.shoepping.bean.*;

import java.io.IOException;
import java.sql.SQLException;

public interface ISellUserShoeController {
    void onInsertSale(BrandBean brand, ModelShoeBean item, PriceBean price, ConditionBean condition, SizeShoeBean size) throws IOException, SQLException, ClassNotFoundException;
    void onReccomendedPriceCalculate(PriceBean price, ConditionBean condition);
}
