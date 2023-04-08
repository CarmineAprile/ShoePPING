package com.example.shoepping.use_case.edit_profile.controller;

import com.example.shoepping.dao.UserDAOCSV;
import com.example.shoepping.dao.UserDAOJDBC;
import com.example.shoepping.model.User;
import com.example.shoepping.use_case.edit_profile.view.IEditProfileView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class EditProfileController implements IEditProfileController{

    IEditProfileView editProfileView;

    public EditProfileController(IEditProfileView editProfileView){
        this.editProfileView = editProfileView;
    }
    @Override
    public void onEditProfile(String username, String pass, String repass, String email, String oldUsername, boolean check) throws CsvValidationException, IOException, SQLException, ClassNotFoundException {

        User user = new User(username, pass, repass, email);
        int registrationCode = user.isValid();

        switch (registrationCode) {
            case 0 -> editProfileView.onEditProfileError("Please enter an Username", 0);
            case 1 -> editProfileView.onEditProfileError("Please enter a Password", 1);
            case 2 -> editProfileView.onEditProfileError("Please enter a Password greater than 6 characters", 2);
            case 3 -> editProfileView.onEditProfileError("Please enter the Re-password", 3);
            case 4 -> editProfileView.onEditProfileError("Passwords do not match", 4);
            case 5 -> editProfileView.onEditProfileError("Please enter an email", 5);
            case 6 -> editProfileView.onEditProfileError("Please enter a valid email", 6);
            default -> {

                // Aggiustare da qui in poi e eseguire l'update e aggiornare i dati di user e passarlo in output per salvarlo nel GC cambiare i dati nel DB

                if (check) {
                    UserDAOCSV userdao = new UserDAOCSV();
                    boolean countUser = userdao.checkExistence(user);

                    if (!countUser) {
                        editProfileView.onEditProfileSuccess(user);
                    } else {
                        editProfileView.onEditProfileError("This username is already taken!", 0);
                    }

                } else {
                    UserDAOJDBC userdao = new UserDAOJDBC();
                    boolean countUser = userdao.checkExistence(user);

                    if(oldUsername.equals(user.getUsername())){
                        countUser = false;
                    }

                    if (!countUser) {
                        user.setUsername(username);
                        user.setPassword(pass);
                        user.setEmail(email);

                        userdao.updateUser(user, oldUsername);

                        editProfileView.onEditProfileSuccess(user);
                    } else {
                        editProfileView.onEditProfileError("This username is already taken!", 0);
                    }
                }
            }
        }
    }
}