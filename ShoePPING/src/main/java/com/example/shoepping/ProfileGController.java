package com.example.shoepping;

import com.example.shoepping.bean.EmailBean;
import com.example.shoepping.bean.UsernameBean;
import com.example.shoepping.use_case.profile.controller.IProfileController;
import com.example.shoepping.use_case.profile.controller.ProfileController;
import com.example.shoepping.use_case.profile.view.IProfileView;
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

public class ProfileGController implements IProfileView {
    @FXML
    HBox myShipments;
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
    @FXML
    HBox exitButton;

    public void start(){
        IProfileController profileController = new ProfileController(this);
        profileController.setLabels();
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
        myOrdersGController.start(orders);


        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void goMySales() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("my-sales-view.fxml"));
        Parent root = loader.load();

        MySalesGController mySalesGController = loader.getController();

        IProfileController profileController = new ProfileController();

        String sales = profileController.onSales();
        mySalesGController.start(sales);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void goMyShipments() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("my-shipments-view.fxml"));
        Parent root = loader.load();

        MyShipmentsGController myShipmentsGController = loader.getController();

        IProfileController profileController = new ProfileController();

        String shipments = profileController.onShipments();
        myShipmentsGController.start(shipments);

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }

    public void showAboutUs() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About-Us");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("ShoePPING app for ISPW project.\nDevelopers: Carmine Aprile, Daniele Ausili.");

        alert.showAndWait();
    }

    public void exit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Parent root = loader.load();

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, profilePane);
    }


    @Override
    public void setLabels(UsernameBean usernameBean, EmailBean emailBean) {
        usernameLabel.setText(usernameBean.getUsername());
        emailLabel.setText(emailBean.getEmail());
    }
}
