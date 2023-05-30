package com.example.shoepping;

import com.example.shoepping.bean.*;
import com.example.shoepping.use_case.login.controller.ILoginController;
import com.example.shoepping.use_case.login.controller.LoginController;
import com.example.shoepping.use_case.login.view.ILoginView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginGController implements ILoginView {

    String usernameLogin = "";
    String passLogin = "";


    @FXML
    CheckBox checkFS;
    @FXML
    TextField loginUsername;
    @FXML
    Label usernameLabel;
    @FXML
    TextField loginPassword;
    @FXML
    Label passwordLabel;
    @FXML
    Text forgotPassword;
    @FXML
    Button loginButton;
    @FXML
    ImageView googleLogo;
    @FXML
    Text createProfile;
    @FXML
    AnchorPane loginPane;



    public void passwordRecovery() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("password-recovery-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }

    public void login() throws Exception {
        usernameLogin = loginUsername.getText();
        passLogin = loginPassword.getText();

        //Serve a "svuotare" le label di errore
        usernameLabel.setText("");
        passwordLabel.setText("");

        boolean check = checkFS.isSelected();

        UsernameBean usernameBean = new UsernameBean();
        PasswordBean passwordBean = new PasswordBean();
        CheckedBean checkedBean = new CheckedBean();

        usernameBean.setUsername(usernameLogin);
        passwordBean.setPassword(passLogin);
        checkedBean.setChecked(check);

        ILoginController loginPresenter = new LoginController(this);
        loginPresenter.onLogin(usernameBean, passwordBean, checkedBean);
    }

    public void googleLogin() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login with Google");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Work in progress...");

        alert.showAndWait();
    }

    public void registration() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }

    public void onLoginSuccessUser() throws IOException{


        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }

    public void onLoginSuccessAdmin() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("administrator-view.fxml"));
        Parent root = loader.load();

        AdministratorGController administratorGController = loader.getController();
        administratorGController.salva();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }


    @Override
    public void onLoginError(MessageBean message, CodeBean codeError) {
        // codeError = 0, manca username
        // codeError = 1, manca password
        // codeError = 2, password lenght <=6
        // codeError = 3, login failed
        // codeError = 10, username greater than 20
        // codeError = 20, password greater than 20

        switch (codeError.getCode()) {
            case 0, 10 -> usernameLabel.setText(message.getMessage());
            case 1, 2, 20 -> passwordLabel.setText(message.getMessage());
            default ->{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(message.getMessage());

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText(message.getMessage());

                alert.showAndWait();
            }
        }

    }

    public void maxLenghtUser() {

        final int maxLengthUser = 20;

        if (loginUsername.getText().length() > maxLengthUser) {
            int pos = loginUsername.getCaretPosition();
            loginUsername.setText(loginUsername.getText(0, maxLengthUser));
            loginUsername.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtPass() {

        final int maxLengthPass = 20;

        if (loginPassword.getText().length() > maxLengthPass) {
            int pos = loginPassword.getCaretPosition();
            loginPassword.setText(loginPassword.getText(0, maxLengthPass));
            loginPassword.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }
}
