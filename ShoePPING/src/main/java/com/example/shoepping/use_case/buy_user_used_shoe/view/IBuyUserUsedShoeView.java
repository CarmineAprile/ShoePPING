package com.example.shoepping.use_case.buy_user_used_shoe.view;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IBuyUserUsedShoeView {
    void onLabelsUpdate(IdBean shoeSale, BrandBean shoeBrand, ModelShoeBean shoeItem, PriceBean shoePrice, SizeShoeBean shoeSize, SellerBean shoeUsername, ConditionBean shoeCondition);

    void onConfirmError(MessageBean message, CodeBean code) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;

    void onConfirmSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException;
}
