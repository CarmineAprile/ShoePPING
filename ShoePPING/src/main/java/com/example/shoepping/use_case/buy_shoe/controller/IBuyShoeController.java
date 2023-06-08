package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.bean.ModelShoeBean;
import com.example.shoepping.bean.OrderVecBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.chart.BarChart;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyShoeController {
    void onUpdate(int shoeSizeList);

    void getSizeAmountList(ModelShoeBean modelShoeBean) throws SQLException, IOException, ClassNotFoundException;

    void onConfirm(OrderVecBean orderVec) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    void onBarchart(BarChart<String, Integer> barchart);
}