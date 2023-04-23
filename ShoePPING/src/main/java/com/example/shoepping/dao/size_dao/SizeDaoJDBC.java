package com.example.shoepping.dao.size_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.pattern.observer.ShoeSizeList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SizeDaoJDBC implements SizeDao{
    @Override
    public ShoeSizeList getSizeList(String model) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getSizeList(conn, model);
    }
}
