package com.example.shoepping.dao.order_Dao;

import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface OrderDao {
    String getOrderList(User instance, boolean check) throws SQLException, IOException, ClassNotFoundException;
}
