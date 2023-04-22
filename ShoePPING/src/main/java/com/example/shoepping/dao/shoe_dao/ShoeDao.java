package com.example.shoepping.dao.shoe_dao;

import java.io.IOException;
import java.sql.SQLException;

public interface ShoeDao{
    String[] getNikePrice() throws SQLException, IOException, ClassNotFoundException;
    String[] getAdidasPrice() throws SQLException, IOException, ClassNotFoundException;
    String[] getNewBalancePrice() throws SQLException, IOException, ClassNotFoundException;
}
