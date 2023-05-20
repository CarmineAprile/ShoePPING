package com.example.shoepping.dao.insert_order_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertOrderDao implements InsertOrderDaoInterface{

    @Override
    public void insertOrder(Order order, User user , int size, boolean check) throws SQLException, IOException, ClassNotFoundException{

        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.insertOrder(conn, order, user, size, check);
    }

    @Override
    public void insertOrderCatalog(Order order, User user, boolean check, String sellID, Sale sale) throws SQLException, IOException, ClassNotFoundException{

        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.insertOrderCatalog(conn, order, user, check, sellID, sale);
    }
}
