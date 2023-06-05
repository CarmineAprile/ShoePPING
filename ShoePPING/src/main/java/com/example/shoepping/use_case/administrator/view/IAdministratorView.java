package com.example.shoepping.use_case.administrator.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IAdministratorView {

    void onUpdateAmountError(MessageBean message, CodeBean errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
    void onUpdateAmountSuccess() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;

    void onUpdatePriceError(MessageBean message, CodeBean errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
    void onUpdatePriceSuccess() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException;
}
