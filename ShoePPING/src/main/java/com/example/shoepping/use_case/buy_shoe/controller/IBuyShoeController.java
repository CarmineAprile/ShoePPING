package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.bean.ModelShoeBean;
import com.example.shoepping.bean.OrderVecBean;
import com.example.shoepping.pattern.observer.ShoeSizeList;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyShoeController {
    void onUpdate(ShoeSizeList shoeSizeList);

    void getSizeAmountList(ModelShoeBean modelShoeBean) throws SQLException, IOException, ClassNotFoundException;

    void onConfirm(OrderVecBean orderVec) throws SQLException, IOException, ClassNotFoundException;
}