package com.example.shoepping.use_case.profile;

import com.example.shoepping.dao.order_dao.OrderDaoJDBC;
import com.example.shoepping.dao.sales_dao.SalesDaoJDBC;
import com.example.shoepping.pattern.singleton.UserSingleton;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileController implements IProfileController{

    @Override
    public String[] setLabels(){
        UserSingleton userSingleton = UserSingleton.getInstance();
        return new String[]{userSingleton.getUser().getUsername(), userSingleton.getUser().getEmail()};
    }

    @Override
    public String onOrders() throws SQLException, IOException, ClassNotFoundException {
        UserSingleton userSingleton = UserSingleton.getInstance();

        OrderDaoJDBC orderDao = new OrderDaoJDBC();
        return orderDao.getOrderList(userSingleton.getUser(), userSingleton.isChecked());
    }

    @Override
    public String onSales() throws SQLException, IOException, ClassNotFoundException {
        UserSingleton userSingleton = UserSingleton.getInstance();
        if(userSingleton.isChecked()){
            return "Not available yet!";
        }

        SalesDaoJDBC salesDao = new SalesDaoJDBC();
        return salesDao.getSalesList(userSingleton.getUser());
    }




}
