package com.example.shoepping.use_case.profile;

import com.example.shoepping.dao.order_dao.OrderDaoJDBC;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileController implements IProfileController{
    @Override
    public String onOrders(User user, boolean isChecked) throws SQLException, IOException, ClassNotFoundException {
        OrderDaoJDBC orderDao = new OrderDaoJDBC();
        return orderDao.getOrderList(user, isChecked);
    }
}
