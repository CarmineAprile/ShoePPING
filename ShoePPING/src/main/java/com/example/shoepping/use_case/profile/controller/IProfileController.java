package com.example.shoepping.use_case.profile.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IProfileController {

    String onOrders() throws SQLException, IOException, ClassNotFoundException;
    void setLabels();
    String onSales() throws SQLException, IOException, ClassNotFoundException;

    String onShipments() throws SQLException, IOException, ClassNotFoundException;
}