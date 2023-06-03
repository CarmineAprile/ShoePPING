package com.example.shoepping.use_case.manage_sale.controller;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IManageSaleController {
    void getSales() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    void onConfirmSale(ItemDataBean itemData) throws SQLException, IOException, ClassNotFoundException;

    void onRefuseSale(ItemDataBean itemData) throws SQLException, IOException, ClassNotFoundException;
}
