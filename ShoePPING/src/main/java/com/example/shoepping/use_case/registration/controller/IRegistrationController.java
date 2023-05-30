package com.example.shoepping.use_case.registration.controller;

import com.example.shoepping.bean.CheckedBean;
import com.example.shoepping.bean.EmailBean;
import com.example.shoepping.bean.PasswordBean;
import com.example.shoepping.bean.UsernameBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IRegistrationController {
    void onRegistration(UsernameBean username, PasswordBean pass, PasswordBean repass, EmailBean email, CheckedBean check) throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException;
}
