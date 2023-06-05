package com.example.shoepping.use_case.login.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoginView {

    void onLoginSuccessUser() throws IOException, SQLException, ClassNotFoundException, CsvValidationException, ManageException;
    void onLoginSuccessAdmin() throws IOException, SQLException, ClassNotFoundException, CsvValidationException, ManageException;
    void onLoginError(MessageBean message, CodeBean codeError) throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException;
}
