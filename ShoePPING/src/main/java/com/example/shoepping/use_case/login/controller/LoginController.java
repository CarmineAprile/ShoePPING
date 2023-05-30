package com.example.shoepping.use_case.login.controller;

import com.example.shoepping.bean.*;
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

        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

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
                messageBean.setMessage("Login failed! Please try again...");
                codeBean.setCode(3);
                loginView.onLoginError(messageBean, codeBean);

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
                messageBean.setMessage("Login failed! Please try again...");
                codeBean.setCode(3);
                loginView.onLoginError(messageBean, codeBean);
            }
        }
    }

    // aggiungere gestione personalizzata dell'eccezione
    @Override
    public void onLogin(UsernameBean username, PasswordBean pass, CheckedBean check) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {

        boolean isAdmin = false;
        User user = new User(username.getUsername(), pass.getPassword());
        UserDao userDao = new UserDAOJDBC();
        if(username.getIsValid() == -1 && pass.getIsValid() == -1) {
            isAdmin = userDao.isAdmin(user);
        }

        if (isAdmin && !check.getChecked())
            loginView.onLoginSuccessAdmin();
        else {
            MessageBean messageBean = new MessageBean();
            CodeBean codeBean = new CodeBean();

            if(username.getIsValid() == 0){
                messageBean.setMessage("Please enter an Username");
                codeBean.setCode(0);
                loginView.onLoginError(messageBean, codeBean);
            } else if(username.getIsValid() == 10){
                messageBean.setMessage("Please enter a Username lower than 20 characters");
                codeBean.setCode(10);
                loginView.onLoginError(messageBean, codeBean);
            } else if(pass.getIsValid() == 1){
                messageBean.setMessage("Please enter a Password");
                codeBean.setCode(1);
                loginView.onLoginError(messageBean, codeBean);
            } else if(pass.getIsValid() == 2){
                messageBean.setMessage("Please enter a Password greater than 6 characters");
                codeBean.setCode(2);
                loginView.onLoginError(messageBean, codeBean);
            }  else if(pass.getIsValid() == 20){
                messageBean.setMessage("Please enter a Password lower than 20 characters");
                codeBean.setCode(20);
                loginView.onLoginError(messageBean, codeBean);
            }else checkTrue(user, check.getChecked());
            }
        }
}
