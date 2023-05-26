package com.example.shoepping.dao.update_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.shoe.Shoe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateDao implements IUpdateDao{

    @Override
    public void updateAmount(Shoe shoe) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.updateAmount(conn, shoe);
    }

    @Override
    public void updatePrice(Shoe shoe) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.updatePrice(conn, shoe);
    }

}
