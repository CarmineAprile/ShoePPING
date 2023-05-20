package com.example.shoepping.use_case.manage_sale.controller;

import com.example.shoepping.dao.sales_dao.SalesDaoJDBC;
import com.example.shoepping.model.sale_storage.SaleStorage;
import com.example.shoepping.model.sale_storage.SaleStorageItem;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.manage_sale.view.IManageSaleView;

import java.io.IOException;
import java.sql.SQLException;

public class ManageSaleController implements IManageSaleController{

    IManageSaleView manageSaleView;
    public ManageSaleController(IManageSaleView manageSaleView) {
        this.manageSaleView = manageSaleView;
    }


    @Override
    public void getSales() throws SQLException, IOException, ClassNotFoundException {


        UserSingleton userSingleton = UserSingleton.getInstance();

        if(userSingleton.isChecked()){
            manageSaleView.setNotAvailableCSV();
        }

        SalesDaoJDBC salesDao = new SalesDaoJDBC();
        SaleStorage saleStorage = salesDao.getManageSalesList(userSingleton.getUser().getUsername());

        for (SaleStorageItem saleStorageItem : saleStorage.getCatalog()) {
            manageSaleView.setSaleButton(saleStorageItem.toString());
        }
    }
}
