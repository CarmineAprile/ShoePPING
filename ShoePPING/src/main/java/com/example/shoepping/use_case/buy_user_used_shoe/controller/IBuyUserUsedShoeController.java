package com.example.shoepping.use_case.buy_user_used_shoe.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserUsedShoeController {
    String setLabels(LabelBean label) throws SQLException, IOException, ClassNotFoundException;
    void onConfirm(ModelShoeBean item, BrandBean brand, PriceBean price, SizeShoeBean size, SellerBean condition, UserVecBean userDataVec, SellIdUpdateBean sellIDUpdate) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;
}
