package com.example.shoepping.use_case.login.controller;

import com.example.shoepping.dao.user_dao.UserDAOCSV;
import com.example.shoepping.dao.user_dao.UserDAOJDBC;
import com.example.shoepping.dao.user_dao.UserDao;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.login.view.ILoginView;
import com.example.shoepping.model.user.User;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController implements ILoginController {

    ILoginView loginView;
    public LoginController(ILoginView loginView){
        this.loginView = loginView;
    }

    public void checkTrue(User user, boolean check) throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException {

        if (check) {

            UserDAOCSV userdao = new UserDAOCSV();
            boolean countUser = userdao.checkLogin(user);
            if (countUser) {

                String emailLogin = userdao.getEmail(user);
                user.setEmail(emailLogin);
                UserSingleton userSingleton = UserSingleton.getInstance();
                userSingleton.setUser(user);
                userSingleton.setChecked(true);

                loginView.onLoginSuccessUser();
            } else {
                loginView.onLoginError("Login failed! Please try again...", 3);
            }

        } else {
            UserDAOJDBC userdao = new UserDAOJDBC();
            boolean countUser = userdao.checkLogin(user);
            if (countUser) {

                String emailLogin = userdao.getEmail(user);
                user.setEmail(emailLogin);

                UserSingleton userSingleton = UserSingleton.getInstance();
                userSingleton.setUser(user);
                userSingleton.setChecked(false);

                loginView.onLoginSuccessUser();
            } else {
                loginView.onLoginError("Login failed! Please try again...", 3);
            }
        }
    }

    // aggiungere gestione personalizzata dell'eccezione
    @Override
    public void onLogin(String username, String pass, boolean check) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {

        User user = new User(username, pass);
        UserDao userDao = new UserDAOJDBC();
        boolean isAdmin = userDao.isAdmin(user);


        if (isAdmin && !check)
            loginView.onLoginSuccessAdmin();
        else {

            int loginCode = user.isValid();
            switch (loginCode) {
                case 0 -> loginView.onLoginError("Please enter an Username", 0);
                case 1 -> loginView.onLoginError("Please enter a Password", 1);
                case 2 -> loginView.onLoginError("Please enter a Password greater than 6 characters", 2);
                default -> checkTrue(user, check);
            }
        }
    }
}
