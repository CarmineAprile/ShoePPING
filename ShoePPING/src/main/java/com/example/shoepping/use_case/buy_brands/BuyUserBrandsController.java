package com.example.shoepping.use_case.buy_brands;


import com.example.shoepping.dao.size_dao.SizeDaoJDBC;
import com.example.shoepping.pattern.observer.ShoeSizeList;

import java.io.IOException;
import java.sql.SQLException;

public class BuyUserBrandsController implements IBuyUserBrandsController{

    @Override
    public ShoeSizeList getSizeAmountList(String model) throws SQLException, IOException, ClassNotFoundException {
        SizeDaoJDBC sizeDao = new SizeDaoJDBC();
        return sizeDao.getSizeList(model);
    }
}
