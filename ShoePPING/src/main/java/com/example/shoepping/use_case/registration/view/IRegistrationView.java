package com.example.shoepping.use_case.registration.view;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IRegistrationView {

    void onRegistrationSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException;

    void onRegistrationError(MessageBean message, CodeBean codeError) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
}
