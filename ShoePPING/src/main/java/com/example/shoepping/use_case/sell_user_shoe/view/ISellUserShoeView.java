package com.example.shoepping.use_case.sell_user_shoe.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.ConditionBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.PriceBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface ISellUserShoeView {
    void onInsertSaleError(MessageBean message, CodeBean code);
    void onInsertSaleSuccess() throws IOException;

    void onRecommendedPriceCalculateError(MessageBean message) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
    void onRecommendedPriceCalculateSuccess(PriceBean price, ConditionBean condition) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
}
