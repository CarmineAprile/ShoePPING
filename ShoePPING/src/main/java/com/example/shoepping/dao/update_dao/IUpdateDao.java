package com.example.shoepping.dao.update_dao;

import com.example.shoepping.model.shoe.Shoe;

import java.io.IOException;
import java.sql.SQLException;

public interface IUpdateDao {
    void updatePrice(Shoe shoe) throws SQLException, IOException, ClassNotFoundException;

    void updateAmount(Shoe shoe) throws SQLException, IOException, ClassNotFoundException;
}
