package com.example.shoepping.use_case.manage_sale.controller;

import com.example.shoepping.dao.sales_dao.SalesDaoJDBC;
import com.example.shoepping.model.sale_storage.SaleStorage;
import com.example.shoepping.model.sale_storage.SaleStorageItem;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.manage_sale.view.IManageSaleView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            List<String> itemData = new ArrayList<>();                          //All strings!
            itemData.add(String.valueOf(saleStorageItem.getStorageSale()));     //index 0: Sale
            itemData.add(saleStorageItem.getStorageBrand());                    //index 1: Brand
            itemData.add(saleStorageItem.getStorageItem());                     //index 2: Item
            itemData.add(String.valueOf(saleStorageItem.getStoragePrice()));    //index 3: Price
            itemData.add(String.valueOf(saleStorageItem.getStorageSize()));     //index 4: Size
            itemData.add(saleStorageItem.getStorageCondition());                //index 5: Condition
            itemData.add(saleStorageItem.getStorageBuyer());                    //index 6: Buyer
            itemData.add(saleStorageItem.getStorageAddress());                  //index 7: Address
            itemData.add(saleStorageItem.getStorageSeller());                   //index 8: Seller
            itemData.add(String.valueOf(saleStorageItem.getStorageIsChecked()));//index 9: Check
            manageSaleView.setSaleButton(saleStorageItem.toString(), itemData);
        }
    }

    @Override
    public void onConfirmSale(List<String> itemData) throws SQLException, IOException, ClassNotFoundException {

        SalesDaoJDBC salesDao = new SalesDaoJDBC();
        SaleStorageItem saleStorageItem = new SaleStorageItem(Integer.parseInt(itemData.get(0)), itemData.get(1), itemData.get(2), Double.parseDouble(itemData.get(3)), Integer.parseInt(itemData.get(4)), itemData.get(5), itemData.get(6), itemData.get(7), itemData.get(8), Integer.parseInt(itemData.get(9)));
        salesDao.confirmSale(saleStorageItem);
    }

    @Override
    public void onRefuseSale(List<String> itemData) throws SQLException, IOException, ClassNotFoundException {

        SalesDaoJDBC salesDao = new SalesDaoJDBC();
        SaleStorageItem saleStorageItem = new SaleStorageItem(Integer.parseInt(itemData.get(0)), itemData.get(1), itemData.get(2), Double.parseDouble(itemData.get(3)), Integer.parseInt(itemData.get(4)), itemData.get(5), itemData.get(6), itemData.get(7), itemData.get(8), Integer.parseInt(itemData.get(9)));
        salesDao.refuseSale(saleStorageItem);
    }


}
