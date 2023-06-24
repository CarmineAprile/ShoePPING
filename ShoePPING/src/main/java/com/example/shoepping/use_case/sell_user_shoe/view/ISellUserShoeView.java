package com.example.shoepping.use_case.sell_user_shoe.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.PriceBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface ISellUserShoeView {
    void onInsertSaleError(MessageBean message, CodeBean code) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
    void onInsertSaleSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException;

    void onRecommendedPriceCalculateError(MessageBean message) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
    void onRecommendedPriceCalculateSuccess(PriceBean recommendedPrice) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
}
