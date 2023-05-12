package com.example.shoepping.use_case.buy_user_used_shoe.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserUsedShoeController {
    void setLabels(String label) throws SQLException, IOException, ClassNotFoundException;
    void onConfirm(String item, String brand, String price, String size, String condition, String[] userDataVec) throws SQLException, IOException, ClassNotFoundException;
}
