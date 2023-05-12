package com.example.shoepping.use_case.profile;

import java.io.IOException;
import java.sql.SQLException;

public interface IProfileController {

    String onOrders() throws SQLException, IOException, ClassNotFoundException;
    String[] setLabels();
    String onSales() throws SQLException, IOException, ClassNotFoundException;
}