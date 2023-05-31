package com.example.shoepping.use_case.edit_profile.controller;

import com.example.shoepping.bean.EmailBean;
import com.example.shoepping.bean.PasswordBean;
import com.example.shoepping.bean.UsernameBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IEditProfileController {

    void onEditProfile(UsernameBean username, PasswordBean pass, PasswordBean repass, EmailBean email) throws CsvValidationException, IOException, SQLException, ClassNotFoundException, ManageException;

    void setNewUser();
}
