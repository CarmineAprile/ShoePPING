package com.example.shoepping.use_case.buy_brands;

import com.example.shoepping.pattern.observer.ShoeSizeList;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserBrandsController {
    ShoeSizeList getSizeAmountList(String model) throws SQLException, IOException, ClassNotFoundException;
}
