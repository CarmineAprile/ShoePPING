package com.example.shoepping.dao.order_Dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
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
}

