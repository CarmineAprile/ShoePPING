package com.example.shoepping.dao.orderDao;

import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface OrderDao {
    String getOrderList(User instance, boolean check) throws SQLException, IOException, ClassNotFoundException;
}
