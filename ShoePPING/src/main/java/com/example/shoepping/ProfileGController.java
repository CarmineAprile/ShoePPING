package com.example.shoepping;

import com.example.shoepping.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ProfileGController {

    User user;
    boolean isChecked;

    @FXML
    AnchorPane profilePane;
    @FXML
    ImageView backButton;
    @FXML
    Label usernameLabel;
    @FXML
    Label emailLabel;
    @FXML
    Button editButton;
    @FXML
    HBox myOrders;
    @FXML
    HBox mySales;
    @FXML
    HBox aboutUs;

    public void salva(User user, boolean isChecked){
        this.user = user;
        this.isChecked = isChecked;

        usernameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();
        buyUserGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void editProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-profile-view.fxml"));
        Parent root = loader.load();

        EditProfileGController editProfileGController = loader.getController();
        editProfileGController.salva(user, isChecked);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void goMyOrders() {
        System.out.println("Orders");
    }

    public void goMySales() {
        System.out.println("Sales");
    }

    public void showAboutUs() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About-Us");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("ShoePPING app for ISPW project.\nDevelopers: Carmine Aprile, Daniele Ausili.");

        alert.showAndWait();
    }
}
