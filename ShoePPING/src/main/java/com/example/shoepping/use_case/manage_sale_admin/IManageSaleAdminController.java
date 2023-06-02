package com.example.shoepping.use_case.manage_sale_admin;

import com.example.shoepping.bean.ItemDataBean;

import java.io.IOException;
import java.sql.SQLException;

public interface IManageSaleAdminController {
    void getSales() throws SQLException, IOException, ClassNotFoundException;

    void onConfirmOrder(ItemDataBean itemData) throws SQLException, IOException, ClassNotFoundException;

    void onRefuseOrder(ItemDataBean itemData) throws SQLException, IOException, ClassNotFoundException;
}
