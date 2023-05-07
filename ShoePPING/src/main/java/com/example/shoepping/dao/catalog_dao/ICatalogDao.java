package com.example.shoepping.dao.catalog_dao;

import com.example.shoepping.model.catalog.Catalog;

import java.io.IOException;
import java.sql.SQLException;

public interface ICatalogDao {
    Catalog getCatalog() throws SQLException, IOException, ClassNotFoundException;
}
