package com.example.shoepping.use_case.buy_catalog.controller;

import com.example.shoepping.exception.ManageException;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyCatalogController {

    void getCatalog() throws SQLException, IOException, ClassNotFoundException;

    void setFilter(String item, String brand, String size, String condition, String price) throws SQLException, IOException, ClassNotFoundException, ManageException;
}
