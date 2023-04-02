package com.example.shoepping.use_case.login.view;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoginView {

    void onLoginSuccessUser() throws IOException, SQLException, ClassNotFoundException, CsvValidationException;
    void onLoginSuccessAdmin() throws IOException;
    void onLoginError(String message, int codeError);
}
