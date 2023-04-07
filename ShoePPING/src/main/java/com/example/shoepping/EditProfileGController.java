package com.example.shoepping;

import com.example.shoepping.model.User;
import com.example.shoepping.use_case.edit_profile.controller.EditProfileController;
import com.example.shoepping.use_case.edit_profile.controller.IEditProfileController;
import com.example.shoepping.use_case.edit_profile.view.IEditProfileView;
import com.opencsv.exceptions.CsvValidationException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class EditProfileGController implements IEditProfileView {

    User user;
    boolean isChecked;
    @FXML
    AnchorPane editProfilePane;
    @FXML
    ImageView backButton;
    @FXML
    TextField usernameTA;
    @FXML
    TextField emailTA;
    @FXML
    TextField passwordTA;
    @FXML
    TextField repasswordTA;
    @FXML
    Label usernameLabel;
    @FXML
    Label emailLabel;
    @FXML
    Label passwordLabel;
    @FXML
    Label repasswordLabel;
    @FXML
    Button editButton;

    public void salva(User user, boolean isChecked){
        this.user = user;
        this.isChecked = isChecked;
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController= loader.getController();
        profileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, editProfilePane);
    }

    public void editProfile() throws CsvValidationException, SQLException, IOException, ClassNotFoundException {
        // aggiungere controllo su check fyleSystem

        String username = usernameTA.getText();
        String pass = passwordTA.getText();
        String repass = repasswordTA.getText();
        String email = emailTA.getText();

        //Serve a "svuotare" le label di errore
        usernameLabel.setText("");
        passwordLabel.setText("");
        repasswordLabel.setText("");
        emailLabel.setText("");

        IEditProfileController editProfileController = new EditProfileController(this);
        editProfileController.onEditProfile(username,pass,repass,email, user.getUsername(), isChecked);

    }

    @Override
    public void onEditProfileSuccess() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        ProfileGController profileGController= loader.getController();
        profileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, editProfilePane);

    }

    @Override
    public void onEditProfileError(String message, int codeError) {
        switch (codeError) {

            // 0. Check for Username Empty
            // 1. Check for Password Empty
            // 2. Check for Password > 6
            // 3. Check for Repassword Empty
            // 4. Check for corrispondence of Password and Repassword
            // 5. Check for Email Empty
            // 6. Check for Email sintax

            case 0 ->
                    usernameLabel.setText(message);

            case 1, 2 ->
                    passwordLabel.setText(message);


            case 3 ->
                    repasswordLabel.setText(message);

            case 4 -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(message);

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.showAndWait();
            }
            default ->
                    emailLabel.setText(message);
        }
    }

    public void maxLenghtUser() {
        final int maxLengthUser = 20;

        if (usernameTA.getText().length() > maxLengthUser) {
            int pos = usernameTA.getCaretPosition();
            usernameTA.setText(usernameTA.getText(0, maxLengthUser));
            usernameTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtPass() {
        final int maxLengthPass = 20;

        if (passwordTA.getText().length() > maxLengthPass) {
            int pos = passwordTA.getCaretPosition();
            passwordTA.setText(passwordTA.getText(0, maxLengthPass));
            passwordTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtRepass() {
        final int maxLengthRepass = 20;

        if (repasswordTA.getText().length() > maxLengthRepass) {
            int pos = repasswordTA.getCaretPosition();
            repasswordTA.setText(repasswordTA.getText(0, maxLengthRepass));
            repasswordTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtEmail() {
        final int maxLengthEmail = 40;

        if (emailTA.getText().length() > maxLengthEmail) {
            int pos = emailTA.getCaretPosition();
            emailTA.setText(emailTA.getText(0, maxLengthEmail));
            emailTA.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }
}
