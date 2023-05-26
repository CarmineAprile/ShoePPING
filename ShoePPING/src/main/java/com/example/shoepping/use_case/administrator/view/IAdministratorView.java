package com.example.shoepping.use_case.administrator.view;

import java.io.IOException;
import java.sql.SQLException;

public interface IAdministratorView {

    void onUpdateAmountError(String message, int errorCode);
    void onUpdateAmountSuccess() throws SQLException, IOException, ClassNotFoundException;

    void onUpdatePriceError(String message, int errorCode);
    void onUpdatePriceSuccess() throws SQLException, IOException, ClassNotFoundException;
}
