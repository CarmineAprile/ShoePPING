package com.example.shoepping.dao.order_dao;

import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.order.OrderList;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface OrderDao {
    String getOrderList(User instance, boolean check) throws SQLException, IOException, ClassNotFoundException;

    OrderList getManageSalesListAdmin() throws SQLException, IOException, ClassNotFoundException;

    void confirmOrder(Order order) throws SQLException, IOException, ClassNotFoundException;

    void refuseOrder(Order order) throws SQLException, IOException, ClassNotFoundException;
}
