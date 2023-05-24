package com.example.shoepping.dao.order_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.order.OrderList;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderDaoJDBC implements OrderDao{

    @Override
    public String getOrderList(User instance, boolean check) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getOrderList(conn, instance.getUsername(), check);
        }

    @Override
    public OrderList getManageSalesListAdmin() throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getManageSalesListAdmin(conn);
    }

    @Override
    public void confirmOrder(Order order) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.confirmOrder(conn, order);
    }

    @Override
    public void refuseOrder(Order order) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.refuseOrder(conn, order);
    }
}