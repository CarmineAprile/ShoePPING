package com.example.shoepping.use_case.login.controller;


import com.example.shoepping.bean.CheckedBean;
import com.example.shoepping.bean.PasswordBean;
import com.example.shoepping.bean.UsernameBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoginController {

    // aggiungere gestione personalizzata dell'eccezione
    void onLogin(UsernameBean username, PasswordBean pass, CheckedBean check) throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException;
}
