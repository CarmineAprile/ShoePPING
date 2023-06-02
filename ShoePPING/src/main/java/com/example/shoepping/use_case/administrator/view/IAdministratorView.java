package com.example.shoepping.use_case.administrator.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;

import java.io.IOException;
import java.sql.SQLException;

public interface IAdministratorView {

    void onUpdateAmountError(MessageBean message, CodeBean errorCode);
    void onUpdateAmountSuccess() throws SQLException, IOException, ClassNotFoundException;

    void onUpdatePriceError(MessageBean message, CodeBean errorCode);
    void onUpdatePriceSuccess() throws SQLException, IOException, ClassNotFoundException;
}
