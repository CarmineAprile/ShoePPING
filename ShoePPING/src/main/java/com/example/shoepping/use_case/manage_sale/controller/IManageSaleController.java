package com.example.shoepping.use_case.manage_sale.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IManageSaleController {
    void getSales() throws SQLException, IOException, ClassNotFoundException;
}
