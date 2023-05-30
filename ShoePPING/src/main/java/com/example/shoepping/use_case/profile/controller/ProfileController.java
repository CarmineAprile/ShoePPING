package com.example.shoepping.use_case.profile.controller;

import com.example.shoepping.bean.EmailBean;
import com.example.shoepping.bean.UsernameBean;
import com.example.shoepping.dao.order_dao.OrderDaoJDBC;
import com.example.shoepping.dao.sales_dao.SalesDaoJDBC;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.profile.view.IProfileView;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileController implements IProfileController{

    IProfileView profileView;

    public ProfileController (IProfileView profileView){
        this.profileView = profileView;
    }

    public ProfileController (){
        //empty;
    }

    @Override
    public void setLabels(){
        UserSingleton userSingleton = UserSingleton.getInstance();
        UsernameBean usernameBean = new UsernameBean();
        EmailBean emailBean = new EmailBean();
        usernameBean.setUsername(userSingleton.getUser().getUsername());
        emailBean.setEmail(userSingleton.getUser().getEmail());

        profileView.setLabels(usernameBean, emailBean);

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

    @Override
    public String onShipments() throws SQLException, IOException, ClassNotFoundException {
        UserSingleton userSingleton = UserSingleton.getInstance();
        if(userSingleton.isChecked()){
            return "Not available yet!";
        }

        SalesDaoJDBC salesDao = new SalesDaoJDBC();
        return salesDao.getShipmentsList(userSingleton.getUser());
    }


}
