package com.example.shoepping.dao.sales_dao;

import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface SalesDao {
    String getSalesList(User instance) throws SQLException, IOException, ClassNotFoundException;
    void  insertSale(Sale sale, String username) throws SQLException, IOException, ClassNotFoundException;
}
