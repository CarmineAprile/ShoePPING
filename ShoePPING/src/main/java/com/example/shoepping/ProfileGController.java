package com.example.shoepping;

import com.example.shoepping.use_case.profile.IProfileController;
import com.example.shoepping.use_case.profile.ProfileController;
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
import java.sql.SQLException;

public class ProfileGController {


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

    public void salva(){

        IProfileController profileController = new ProfileController();
        String[] valueLabels = profileController.setLabels();
        usernameLabel.setText(valueLabels[0]);
        emailLabel.setText(valueLabels[1]);
    }

    public void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();


        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void editProfile() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-profile-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void goMyOrders() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("my-orders-view.fxml"));
        Parent root = loader.load();

        MyOrdersGController myOrdersGController = loader.getController();

        IProfileController profileController = new ProfileController();


        String orders = profileController.onOrders();

        myOrdersGController.salva(orders);


        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
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
