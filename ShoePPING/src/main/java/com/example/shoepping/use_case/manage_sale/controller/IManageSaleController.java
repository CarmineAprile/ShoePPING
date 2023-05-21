package com.example.shoepping.use_case.manage_sale.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IManageSaleController {
    void getSales() throws SQLException, IOException, ClassNotFoundException;

    void onConfirmSale(List<String> itemData) throws SQLException, IOException, ClassNotFoundException;

    void onRefuseSale(List<String> itemData) throws SQLException, IOException, ClassNotFoundException;
}
