package com.example.shoepping.dao.size_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.pattern.observer.ShoeSizeSubject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SizeDaoJDBC implements SizeDao{
    @Override
    public ShoeSizeSubject getSizeList(String model) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getSizeList(conn, model);
    }
}
