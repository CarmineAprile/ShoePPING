package com.example.shoepping.use_case.administrator.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IAdministratorController {
    void onUpdateAmount(String idAmount, String amount, String size) throws SQLException, IOException, ClassNotFoundException;

    void onUpdatePrice(String idAmount, String price) throws SQLException, IOException, ClassNotFoundException;

    String getReport() throws SQLException, IOException, ClassNotFoundException;
}
