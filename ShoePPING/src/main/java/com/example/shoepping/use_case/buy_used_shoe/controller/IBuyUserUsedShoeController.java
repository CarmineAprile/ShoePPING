package com.example.shoepping.use_case.buy_used_shoe.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserUsedShoeController {

    void getCatalog() throws SQLException, IOException, ClassNotFoundException;

    void setFilter(String item, String brand, String size, String condition, String price) throws SQLException, IOException, ClassNotFoundException;
}
