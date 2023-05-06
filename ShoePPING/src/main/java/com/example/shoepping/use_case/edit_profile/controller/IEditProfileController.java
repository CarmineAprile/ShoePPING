package com.example.shoepping.use_case.edit_profile.controller;

import com.example.shoepping.exception.DAOException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IEditProfileController {

    void onEditProfile(String username, String pass, String repass, String email) throws CsvValidationException, IOException, SQLException, ClassNotFoundException, DAOException;

    void setNewUser();
}
