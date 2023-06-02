package com.example.shoepping.use_case.edit_profile.view;

import com.example.shoepping.bean.CheckedBean;
import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.UserBean;
import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IEditProfileView {

    void onEditProfileSuccess(CheckedBean checkedBean, UserBean userNew) throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException;

    void onEditProfileError(MessageBean messageBean, CodeBean codeBean) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException;
}
