package com.example.shoepping.use_case.manage_sale_admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IManageSaleAdminController {
    void getSales() throws SQLException, IOException, ClassNotFoundException;

    void onConfirmOrder(List<String> itemData) throws SQLException, IOException, ClassNotFoundException;

    void onRefuseOrder(List<String> itemData) throws SQLException, IOException, ClassNotFoundException;
}
