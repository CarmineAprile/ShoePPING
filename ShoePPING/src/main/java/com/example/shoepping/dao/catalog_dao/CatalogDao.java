package com.example.shoepping.dao.catalog_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.catalog.Catalog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CatalogDao implements ICatalogDao{

    @Override
    public Catalog getCatalog() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getCatalog(conn);
    }
}
