package com.example.shoepping.dao.shoe_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ShoeDaoJDBC implements ShoeDao{

    @Override
    public String[] getNikePrice() throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getNikePrice(conn);
    }

    @Override
    public String[] getAdidasPrice() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getAdidasPrice(conn);
    }

    @Override
    public String[] getNewBalancePrice() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getNewBalancePrice(conn);
    }
}
