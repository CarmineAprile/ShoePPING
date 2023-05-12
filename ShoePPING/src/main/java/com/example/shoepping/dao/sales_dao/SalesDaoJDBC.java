package com.example.shoepping.dao.sales_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SalesDaoJDBC implements SalesDao{

    @Override
    public String getSalesList(User user) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getSalesList(conn, user.getUsername());
    }
}
