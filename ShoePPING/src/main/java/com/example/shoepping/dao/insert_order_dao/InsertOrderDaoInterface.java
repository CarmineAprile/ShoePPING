package com.example.shoepping.dao.insert_order_dao;

import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface InsertOrderDaoInterface {
    void insertOrder(Order order, User user, int size, boolean check) throws SQLException, IOException, ClassNotFoundException;

    void insertOrderCatalog(Order order, User user, boolean check, String sellID, Sale sale) throws SQLException, IOException, ClassNotFoundException;
}
