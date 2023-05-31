package com.example.shoepping.use_case.registration.controller;


import com.example.shoepping.bean.*;
import com.example.shoepping.dao.user_dao.UserDAOCSV;
import com.example.shoepping.dao.user_dao.UserDAOJDBC;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.user.User;
import com.example.shoepping.use_case.registration.view.IRegistrationView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController implements IRegistrationController {

    IRegistrationView registrationView;

    public RegistrationController(IRegistrationView registrationView){
        this.registrationView = registrationView;
    }


    @Override
    public void onRegistration(UsernameBean username, PasswordBean pass, PasswordBean repass, EmailBean email, CheckedBean check) throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException {

        User user = new User(username.getUsername(), pass.getPassword(), email.getEmail());

        if(username.getIsValid() == 0){
            utilityOnRegistration("Please enter an Username", 0);
        } else if(username.getIsValid() == 10){
            utilityOnRegistration("Please enter a Username lower than 20 characters", 10);
        } else if(pass.getIsValid() == 1){
            utilityOnRegistration("Please enter a Password", 1);
        } else if(pass.getIsValid() == 2){
            utilityOnRegistration("Please enter a Password greater than 6 characters", 2);
        }  else if(pass.getIsValid() == 20){
            utilityOnRegistration("Please enter a Password lower than 20 characters", 20);
        } else if(repass.getIsValid() == 3){
            utilityOnRegistration("Please enter the Re-password", 3);
        } else if(!(pass.getPassword().equals(repass.getPassword()))){
            utilityOnRegistration("Passwords do not match", 4);
        } else if(email.getIsValid() == 5){
            utilityOnRegistration("Please enter an email", 5);
        } else if(email.getIsValid() == 6){
            utilityOnRegistration("Please enter a valid email", 6);
        } else if(email.getIsValid() == 30){
            utilityOnRegistration("Please enter an email lower than 40 characters", 30);
        }else{
                onRegistrationCallDao(check.getChecked(), user);
            }
        }


        private void onRegistrationCallDao(boolean isChecked, User user ) throws CsvValidationException, IOException, SQLException, ClassNotFoundException, ManageException {
            if (isChecked) {
                UserDAOCSV userdao = new UserDAOCSV();
                boolean countUser = userdao.checkExistence(user);

                if (!countUser) {
                    userdao.addUser(user);
                    registrationView.onRegistrationSuccess();
                } else {
                    utilityOnRegistration("This username is already taken!", 0);
                }

            } else {
                UserDAOJDBC userdao = new UserDAOJDBC();
                boolean countUser = userdao.checkExistence(user);

                if (!countUser) {
                    userdao.addUser(user);
                    registrationView.onRegistrationSuccess();
                } else {
                    utilityOnRegistration("This username is already taken!", 0);
                }
            }
        }
    private void utilityOnRegistration(String message, int errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        registrationView.onRegistrationError(messageBean, codeBean);
    }

    }
