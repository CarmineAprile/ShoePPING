package com.example.shoepping.use_case.registration.view;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IRegistrationView {

    void onRegistrationSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException;

    void onRegistrationError(String message, int codeError) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
}
