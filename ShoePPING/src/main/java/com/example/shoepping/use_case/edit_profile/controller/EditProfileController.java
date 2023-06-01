package com.example.shoepping.use_case.edit_profile.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.dao.user_dao.UserDAOCSV;
import com.example.shoepping.dao.user_dao.UserDAOJDBC;
import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.edit_profile.view.IEditProfileView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class EditProfileController implements IEditProfileController{

    IEditProfileView editProfileView;
    static User userNew;

    public EditProfileController(IEditProfileView editProfileView){
        this.editProfileView = editProfileView;
    }
    @Override
    public void onEditProfile(UsernameBean username, PasswordBean pass, PasswordBean repass, EmailBean email) throws CsvValidationException, IOException, SQLException, ClassNotFoundException {

        User user = new User(username.getUsername(), pass.getPassword(), email.getEmail());
        UserSingleton userSingleton = UserSingleton.getInstance();

        String oldUsername = userSingleton.getUser().getUsername();
        boolean check = userSingleton.isChecked();

        if(username.getIsValid() == 0){
            utilityOnEdit("Please enter an Username", 0);
        } else if(username.getIsValid() == 10){
            utilityOnEdit("Please enter a Username lower than 20 characters", 10);
        } else if(pass.getIsValid() == 1){
            utilityOnEdit("Please enter a Password", 1);
        } else if(pass.getIsValid() == 2){
            utilityOnEdit("Please enter a Password greater than 6 characters", 2);
        }  else if(pass.getIsValid() == 20){
            utilityOnEdit("Please enter a Password lower than 20 characters", 20);
        } else if(repass.getIsValid() == 3){
            utilityOnEdit("Please enter the Re-password", 3);
        } else if(!(pass.getPassword().equals(repass.getPassword()))){
            utilityOnEdit("Passwords do not match", 4);
        } else if(email.getIsValid() == 5){
            utilityOnEdit("Please enter an email", 5);
        } else if(email.getIsValid() == 6){
            utilityOnEdit("Please enter a valid email", 6);
        } else if(email.getIsValid() == 30) {
            utilityOnEdit("Please enter an email lower than 40 characters", 30);
        } else {
            utilityOnEdit(check, user, oldUsername, username, pass, email);
        }
    }


    @Override
    public void setNewUser() {

        UserSingleton userSingleton = UserSingleton.getInstance();
        userSingleton.setUser(userNew);
    }

    private void utilityOnEdit(String message, int errorCode) {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        editProfileView.onEditProfileError(messageBean, codeBean);
    }

    private void utilityOnEdit(boolean check, User user, String oldUsername, UsernameBean username, PasswordBean pass, EmailBean email) throws CsvValidationException, IOException, SQLException, ClassNotFoundException {
        if (check) {
            UserDAOCSV userdao = new UserDAOCSV();
            boolean countUser = userdao.checkExistence(user);

            if (!countUser) {
                CheckedBean checkedBean = new CheckedBean();
                checkedBean.setChecked(true);
                editProfileView.onEditProfileSuccess(checkedBean);
            } else {
                MessageBean messageBean = new MessageBean();
                CodeBean codeBean = new CodeBean();
                messageBean.setMessage("This username is already taken!");
                codeBean.setCode(0);
                editProfileView.onEditProfileError(messageBean, codeBean);
            }

        } else {

            UserDAOJDBC userdao = new UserDAOJDBC();
            boolean countUser = userdao.checkExistence(user);

            if(oldUsername.equals(user.getUsername())){
                countUser = false;
            }

            if (!countUser) {
                user.setUsername(username.getUsername());
                user.setPassword(pass.getPassword());
                user.setEmail(email.getEmail());

                userdao.updateUser(user, oldUsername);

                userNew = user;

                CheckedBean checkedBean = new CheckedBean();
                checkedBean.setChecked(false);
                editProfileView.onEditProfileSuccess(checkedBean);
            } else {
                MessageBean messageBean = new MessageBean();
                CodeBean codeBean = new CodeBean();
                messageBean.setMessage("This username is already taken!");
                codeBean.setCode(0);
                editProfileView.onEditProfileError(messageBean, codeBean);
            }
        }
    }
}