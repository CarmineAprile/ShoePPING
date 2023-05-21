package com.example.shoepping.dao.sales_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.model.sale_storage.SaleStorage;
import com.example.shoepping.model.sale_storage.SaleStorageItem;
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

    @Override
    public void insertSale(Sale sale, String username) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.insertSale(conn, sale, username);
    }

    @Override
    public SaleStorage getManageSalesList(String username) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getSaleStorage(conn, username);
    }

    @Override
    public void confirmSale(SaleStorageItem saleStorageItem) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.confirmSale(conn, saleStorageItem);
    }

    @Override
    public void refuseSale(SaleStorageItem saleStorageItem) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.refuseSale(conn, saleStorageItem);
    }
}
