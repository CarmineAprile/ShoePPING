package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.bean.ModelShoeBean;
import com.example.shoepping.bean.OrderVecBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyShoeController {
    void onUpdate(int sizeButton);

    void getSizeAmountList(ModelShoeBean modelShoeBean) throws SQLException, IOException, ClassNotFoundException;

    void onConfirm(OrderVecBean orderVec) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    void onBarchart(XYChart.Series<String, Integer> barchart);
}